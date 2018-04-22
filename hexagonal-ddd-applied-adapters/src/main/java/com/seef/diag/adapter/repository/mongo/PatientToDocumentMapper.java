package com.seef.diag.adapter.repository.mongo;

import com.seef.diag.domain.model.Patient;

public interface PatientToDocumentMapper {

    PatientDocument toDocument(Patient patient);
    Patient toDomain(PatientDocument patientDocument);

}
