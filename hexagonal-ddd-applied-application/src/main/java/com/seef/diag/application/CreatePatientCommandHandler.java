package com.seef.diag.application;

import com.seef.diag.commons.CommandHandler;
import com.seef.diag.commons.CommandResponse;
import com.seef.diag.domain.command.CreatePatientCommand;
import com.seef.diag.domain.port.PatientRepository;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CreatePatientCommandHandler implements CommandHandler<CreatePatientCommand> {

    private PatientRepository patientRepository;

    @Inject
    public CreatePatientCommandHandler(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public CommandResponse handle(CreatePatientCommand command) {

        return null;
    }
}
