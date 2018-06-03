package com.seef.diag.patient;

interface PatientToDocumentMapper {

    PatientDocument toDocument(Patient patient);
    Patient toDomain(PatientDocument patientDocument);

}
