package com.seef.diag.domain.port;

import com.seef.diag.commons.TenantId;
import com.seef.diag.domain.model.Patient;
import com.seef.diag.domain.model.PatientId;
import com.seef.diag.domain.model.PatientName;

import java.util.List;

public interface PatientRepository {
    Patient save(Patient patient);
    Patient findOneBy(PatientId patientId, TenantId tenantId);
    List<Patient> findPatientsMatching(PatientName patientName, TenantId tenantId);
}
