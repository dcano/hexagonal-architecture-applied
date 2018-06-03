package com.seef.diag.patient;

interface PatientToJpaMapper {

    PatientJpa toJpa(Patient patient);
    Patient toDomain(PatientJpa patientDocument);

}
