package com.seef.diag.domain.services;

import com.seef.diag.commons.TenantId;
import com.seef.diag.domain.model.Patient;
import com.seef.diag.domain.model.PatientId;
import com.seef.diag.domain.port.PatientRepository;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class PatientMergeService {

    private PatientRepository patientRepository;

    @Inject
    public PatientMergeService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient mergePatients(PatientId sourcePatientId, PatientId destinationPatientId, TenantId tenantId) {
        Patient sourcePatient = patientRepository.findOneBy(sourcePatientId, tenantId);
        Patient destinationPatient = patientRepository.findOneBy(destinationPatientId, tenantId);
        destinationPatient.incorporatePatient(sourcePatient);
        return destinationPatient;
    }

}
