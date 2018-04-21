package com.seef.diag.application;

import com.seef.diag.commons.CommandHandler;
import com.seef.diag.commons.CommandResponse;
import com.seef.diag.domain.command.AddPatientCommentCommand;
import com.seef.diag.domain.port.PatientRepository;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class AddPatientCommentCommandHandler implements CommandHandler<AddPatientCommentCommand> {

    private PatientRepository patientRepository;

    @Inject
    public AddPatientCommentCommandHandler(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public CommandResponse handle(AddPatientCommentCommand command) {
        return null;
    }
}
