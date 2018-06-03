package com.seef.diag.application;

import com.seef.diag.commons.CommandHandler;
import com.seef.diag.commons.TenantId;
import com.seef.diag.domain.command.MergePatientsCommand;
import com.seef.diag.domain.model.Patient;
import com.seef.diag.domain.model.PatientId;
import com.seef.diag.domain.port.PatientOutputPort;
import com.seef.diag.domain.port.PatientRepository;
import com.seef.diag.domain.services.PatientMergeService;

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
