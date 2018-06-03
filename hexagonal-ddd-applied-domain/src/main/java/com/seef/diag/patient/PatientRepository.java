package com.seef.diag.patient;

import com.seef.diag.commons.TenantId;
import com.seef.diag.patient.ClinicalIdentifier;
import com.seef.diag.patient.Patient;
import com.seef.diag.patient.PatientId;
import com.seef.diag.patient.PatientName;

import java.util.List;

interface PatientRepository {
    Patient save(Patient patient);
    Patient findOneBy(PatientId patientId, TenantId tenantId);
    Patient findOneBy(ClinicalIdentifier clinicalIdentifier, TenantId tenantId);
    List<Patient> findPatientsMatching(PatientName patientName, TenantId tenantId);
}
