package com.seef.diag.adapter.repository.jpa.patient;

import com.seef.diag.domain.model.Patient;

public interface PatientToJpaMapper {

    PatientJpa toJpa(Patient patient);
    Patient toDomain(PatientJpa patientDocument);

}
