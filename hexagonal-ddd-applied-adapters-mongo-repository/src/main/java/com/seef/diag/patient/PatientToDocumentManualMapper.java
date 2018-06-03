package com.seef.diag.patient;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
class PatientToDocumentManualMapper implements PatientToDocumentMapper {

    private PatientToDocument patientToDocumentHelper;
    private DocumentToPatient documentToPatientHelper;

    PatientToDocumentManualMapper() {
        patientToDocumentHelper = new PatientToDocument();
        documentToPatientHelper = new DocumentToPatient();
    }

    @Override
    public PatientDocument toDocument(Patient patient) {
        return patientToDocumentHelper.apply(patient);
    }

    @Override
    public Patient toDomain(PatientDocument patientDocument) {
        return documentToPatientHelper.apply(patientDocument);
    }

    private static class PatientToDocument implements Function<Patient, PatientDocument> {

        @Override
        public PatientDocument apply(Patient patient) {
            List<CommentDocument> comments = patient.getComments()!=null?patient.getComments().stream().map(c -> new CommentDocument(c.getComment(), c.getCriticality())).collect(Collectors.toList()):null;
            PatientDocument patientDocument = new PatientDocument();
            patientDocument.setId(patient.getPatientId().value());
            patientDocument.setBirthDay(patient.getBirthDay());
            patientDocument.setClinicalIdentifier(patient.getClinicalIdentifier().value());
            patientDocument.setComments(comments);
            patientDocument.setContactInfo(new ContactInfoDocument(patient.getContactInfo().getEmail(),
                    patient.getContactInfo().getAddress().getStreet(),
                    patient.getContactInfo().getAddress().getNumber(),
                    patient.getContactInfo().getAddress().getZip(),
                    patient.getContactInfo().getAddress().getTown(),
                    patient.getContactInfo().getAddress().getState(),
                    patient.getContactInfo().getAddress().getCountry(),
                    patient.getContactInfo().getPhoneNumbers().stream().map(p -> new PhoneNumberDocument(p.getNumber(), p.getPhoneType())).collect(Collectors.toList())));
            patientDocument.setStatus(patient.getStatus());
            patientDocument.setTenantId(patient.getTenantId().getId());
            patientDocument.setPatientName(new PatientNameDocument(patient.getPatientName().getFirstName(),
                    patient.getPatientName().getSurname1(),
                    patient.getPatientName().getSurname2()));
            return patientDocument;
        }
    }

    private static class DocumentToPatient implements Function<PatientDocument, Patient> {

        @Override
        public Patient apply(PatientDocument patientDocument) {
            return Patient.builder()
                    .withPatientId(patientDocument.getId())
                    .withBirthDate(patientDocument.getBirthDay())
                    .withClinicalIdentifier(patientDocument.getClinicalIdentifier())
                    .withComments(patientDocument.getComments()!=null?patientDocument.getComments().stream().map(c -> new Comment(c.getComment(), c.getCriticality())).collect(Collectors.toList()):null)
                    .withContactInfo(new ContactInfo(patientDocument.getContactInfo().getPhoneNumbers()
                            .stream()
                            .map(p -> new PhoneNumber(p.getNumber(), p.getPhoneType()))
                            .collect(Collectors.toList()),
                            Address.builder()
                                    .withStreet(patientDocument.getContactInfo().getStreet())
                                    .withNumber(patientDocument.getContactInfo().getNumber())
                                    .withZip(patientDocument.getContactInfo().getZip())
                                    .withTown(patientDocument.getContactInfo().getTown())
                                    .withState(patientDocument.getContactInfo().getState())
                                    .withCountry(patientDocument.getContactInfo().getCountry()).build(),
                            patientDocument.getContactInfo().getEmail()))
                    .withPatientName(patientDocument.getPatientName().getFirstName())
                    .withSurname1(patientDocument.getPatientName().getSurname1())
                    .withSurname2(patientDocument.getPatientName().getSurname2())
                    .withPatientStatus(patientDocument.getStatus())
                    .withTenantId(patientDocument.getTenantId())
                    .instanceExistingPatient();
        }
    }

}
