package com.seef.diag.patient;

import com.seef.diag.commons.TenantId;
import org.assertj.core.api.WithAssertions;
import org.junit.Test;

import java.util.List;
import java.util.UUID;


public class PatientRepositoryTest implements WithAssertions {

    private PatientRepository patientRepository;

    public void setPatientRepository(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Test
    public void given_a_patient_it_is_stored_successfully() {
        String tenantId = UUID.randomUUID().toString();
        Patient patientExpected = PatientTestStub.randomPatientForTenant(tenantId);
        patientRepository.save(patientExpected);

        Patient patientActual = patientRepository.findOneBy(patientExpected.getPatientId(), patientExpected.getTenantId());
        assertThat(patientActual).as("Patient is not null").isNotNull();
        assertThat(patientActual.getPatientId().value()).as("Patient has expected id").isEqualTo(patientExpected.getPatientId().value());
        //TODO add more asserts
    }

    @Test
    public void given_a_patient_it_is_found_successfully_by_clinical_identifier() {
        String tenantId = UUID.randomUUID().toString();
        Patient patientExpected = PatientTestStub.randomPatientForTenant(tenantId);
        patientRepository.save(patientExpected);
        Patient patientActual = patientRepository.findOneBy(patientExpected.getClinicalIdentifier(), patientExpected.getTenantId());
        assertThat(patientActual).as("Patient is not null").isNotNull();
        assertThat(patientActual.getPatientId().value()).as("Patient has expected id").isEqualTo(patientExpected.getPatientId().value());
        //TODO add more asserts
    }

    @Test
    public void given_a_set_of_patients_with_same_name_they_are_found_successfully() {
        int numberOfPatients = 3;
        String tenantId = UUID.randomUUID().toString();
        List<Patient> expectedPatientList = PatientTestStub.generateNumberOfPatientsForTenantWithSameName(numberOfPatients, tenantId);
        expectedPatientList.forEach(patientRepository::save);

        List<Patient> actualPatientList = patientRepository.findPatientsMatching(expectedPatientList.get(0).getPatientName(), TenantId.of(tenantId));
        assertThat(actualPatientList).as("Actual patient list is not null").isNotNull();
        assertThat(actualPatientList.size()).as("Patient list has expected size").isEqualTo(expectedPatientList.size());
        //TODO add more asserts
    }

}
