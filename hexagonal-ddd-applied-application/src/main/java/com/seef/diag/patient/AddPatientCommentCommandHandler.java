package com.seef.diag.patient;

import com.seef.diag.commons.CommandHandler;
import com.seef.diag.commons.TenantId;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class AddPatientCommentCommandHandler implements CommandHandler<AddPatientCommentCommand> {

    private PatientRepository patientRepository;
    private PatientOutputPort patientOutputPort;

    @Inject
    public AddPatientCommentCommandHandler(PatientRepository patientRepository, PatientOutputPort patientOutputPort) {
        this.patientRepository = patientRepository;
        this.patientOutputPort = patientOutputPort;
    }

    @Override
    public void handle(AddPatientCommentCommand command) {
        Patient patient = patientRepository.findOneBy(PatientId.of(command.getPatientId()), TenantId.of(command.tenantId()));
        if(patient == null) {
            throw new IllegalStateException("Patient with id " + command.getPatientId() + " does not exists.");
        }
        patient.addComment(command.getComment(), command.getCommentCriticality());
        patientRepository.save(patient);
        patientOutputPort.write(patient, command);
    }
}
