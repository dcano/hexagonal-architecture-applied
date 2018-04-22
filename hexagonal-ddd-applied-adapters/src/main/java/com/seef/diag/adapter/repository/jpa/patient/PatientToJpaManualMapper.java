package com.seef.diag.adapter.repository.jpa.patient;

import com.seef.diag.domain.model.Address;
import com.seef.diag.domain.model.ContactInfo;
import com.seef.diag.domain.model.Patient;
import com.seef.diag.domain.model.PhoneNumber;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class PatientToJpaManualMapper implements PatientToJpaMapper {

    private PatientToJpa patientToJpaMapperHelper;
    private JpaToPatient jpaToPatientMapperHelper;

    public PatientToJpaManualMapper() {
        this.patientToJpaMapperHelper = new PatientToJpa();
        this.jpaToPatientMapperHelper = new JpaToPatient();
    }

    @Override
    public PatientJpa toJpa(Patient patient) {
        return patientToJpaMapperHelper.apply(patient);
    }

    @Override
    public Patient toDomain(PatientJpa patientJpa) {
        return jpaToPatientMapperHelper.apply(patientJpa);
    }

    private static class PatientToJpa implements Function<Patient, PatientJpa> {

        @Override
        public PatientJpa apply(Patient patient) {
            PatientJpa patientJpa = new PatientJpa();
            patientJpa.setBirthDate(patient.getBirthDay());
            patientJpa.setPatientName(patient.getPatientName().getFirstName());
            patientJpa.setSurname1(patient.getPatientName().getSurname1());
            patientJpa.setSurname2(patient.getPatientName().getSurname2());
            patientJpa.setClinicalIdentifier(patient.getClinicalIdentifier().value());
            patientJpa.setId(patient.getPatientId().value());
            patientJpa.setPatientStatus(patient.getStatus());
            patientJpa.setTenantId(patient.getTenantId().getId());
            patientJpa.setComments(patient.getComments()!=null?patient.getComments().stream().map(c -> new CommentJpa(c.getComment(), c.getCriticality())).collect(Collectors.toList()):null);
            patientJpa.setContactInfo(new ContactInfoJpa(patient.getContactInfo().getAddress().getStreet(),
                    patient.getContactInfo().getAddress().getNumber(),
                    patient.getContactInfo().getAddress().getZip(),
                    patient.getContactInfo().getAddress().getTown(),
                    patient.getContactInfo().getAddress().getState(),
                    patient.getContactInfo().getAddress().getCountry(), patient.getContactInfo().getEmail(),
                    patient.getContactInfo().getPhoneNumbers()
                            .stream()
                            .map(p -> new PhoneNumberJpa(p.getNumber(), p.getPhoneType()))
                            .collect(Collectors.toList())));
            return patientJpa;
        }
    }

    private static class JpaToPatient implements Function<PatientJpa, Patient> {

        @Override
        public Patient apply(PatientJpa patientJpa) {
            Patient patient = Patient.builder()
                    .withPatientName(patientJpa.getPatientName())
                    .withSurname1(patientJpa.getSurname1())
                    .withSurname2(patientJpa.getSurname2())
                    .withPatientId(patientJpa.getId())
                    .withBirthDate(patientJpa.getBirthDate())
                    .withClinicalIdentifier(patientJpa.getClinicalIdentifier())
                    .withPatientStatus(patientJpa.getPatientStatus())
                    .withTenantId(patientJpa.getTenantId())
                    .withContactInfo(new ContactInfo(patientJpa.getContactInfo().getPhoneNumbers().stream().map(p -> new PhoneNumber(p.getNumber(), p.getPhoneType())).collect(Collectors.toList()),
                            Address.builder()
                                    .withStreet(patientJpa.getContactInfo().getStreet())
                                    .withNumber(patientJpa.getContactInfo().getNumber())
                                    .withCountry(patientJpa.getContactInfo().getCountry())
                                    .withState(patientJpa.getContactInfo().getState())
                                    .withZip(patientJpa.getContactInfo().getZip())
                                    .build(),
                            patientJpa.getContactInfo().getEmail()))
                    .instanceExistingPatient();
            return patient;
        }
    }

}
