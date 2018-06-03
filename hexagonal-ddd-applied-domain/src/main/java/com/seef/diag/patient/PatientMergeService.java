package com.seef.diag.patient;

import com.seef.diag.commons.TenantId;

import javax.inject.Inject;
import javax.inject.Named;

@Named
class PatientMergeService {

    private PatientRepository patientRepository;

    @Inject
    public PatientMergeService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    Patient mergePatients(PatientId sourcePatientId, PatientId destinationPatientId, TenantId tenantId) {
        Patient sourcePatient = patientRepository.findOneBy(sourcePatientId, tenantId);
        if(sourcePatient == null) {
            throw new IllegalStateException("Source patient with id " + sourcePatient.getPatientId().value() + " at tenant id " + tenantId.getId() + " does not exists");
        }
        Patient destinationPatient = patientRepository.findOneBy(destinationPatientId, tenantId);
        if(destinationPatient == null) {
            throw new IllegalStateException("Destination patient with id " + destinationPatient.getPatientId().value() + " at tenant id " + tenantId.getId() + " does not exists");
        }
        destinationPatient.incorporatePatient(sourcePatient);
        return destinationPatient;
    }

}
