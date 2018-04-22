package com.seef.diag.adapter.repository.mongo.patient;

import com.seef.diag.domain.model.Patient;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class PatientToDocumentManualMapper implements PatientToDocumentMapper {

    private PatientToDocument patientToDocumentHelper;
    private DocumentToPatient documentToPatientHelper;

    public PatientToDocumentManualMapper() {
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
            PatientDocument patientDocument = new PatientDocument();
            patientDocument.setId(patient.getPatientId().value());
            patientDocument.setBirthDay(patient.getBirthDay());
            patientDocument.setClinicalIdentifier(patient.getClinicalIdentifier().value());
            patientDocument.setComments(patient.getComments());
            patientDocument.setContactInfo(patient.getContactInfo());
            patientDocument.setStatus(patient.getStatus());
            patientDocument.setTenantId(patient.getTenantId().getId());
            patientDocument.setPatientName(patient.getPatientName());
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
                    .withComments(patientDocument.getComments())
                    .withContactInfo(patientDocument.getContactInfo())
                    .withPatientName(patientDocument.getPatientName().getFirstName())
                    .withSurname1(patientDocument.getPatientName().getSurname1())
                    .withSurname2(patientDocument.getPatientName().getSurname2())
                    .withPatientStatus(patientDocument.getStatus())
                    .withTenantId(patientDocument.getTenantId())
                    .instanceExistingPatient();
        }
    }

}
