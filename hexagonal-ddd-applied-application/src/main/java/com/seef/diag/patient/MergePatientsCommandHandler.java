package com.seef.diag.patient;

import com.seef.diag.commons.CommandHandler;
import com.seef.diag.commons.TenantId;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class MergePatientsCommandHandler implements CommandHandler<MergePatientsCommand> {

    private PatientMergeService patientMergeService;
    private PatientOutputPort patientOutputPort;

    @Inject
    public MergePatientsCommandHandler(PatientRepository patientRepository, PatientOutputPort patientOutputPort) {
        this.patientOutputPort = patientOutputPort;
        this.patientMergeService = new PatientMergeService(patientRepository);
    }

    @Override
    public void handle(MergePatientsCommand command) {
        Patient destinationPatient = patientMergeService.mergePatients(PatientId.of(command.getSourcePatientId()), PatientId.of(command.getDestinationPatientId()), TenantId.of(command.tenantId()));
        patientOutputPort.write(destinationPatient, command);
    }
}
