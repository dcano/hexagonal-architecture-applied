package com.seef.diag.domain.port;

import com.seef.diag.commons.TenantId;
import com.seef.diag.domain.model.ClinicalIdentifier;
import com.seef.diag.domain.model.Patient;
import com.seef.diag.domain.model.PatientId;
import com.seef.diag.domain.model.PatientName;

import java.util.List;

public interface PatientRepository {
    Patient save(Patient patient);
    Patient findOneBy(PatientId patientId, TenantId tenantId);
    Patient findOneBy(ClinicalIdentifier clinicalIdentifier, TenantId tenantId);
    List<Patient> findPatientsMatching(PatientName patientName, TenantId tenantId);
}
