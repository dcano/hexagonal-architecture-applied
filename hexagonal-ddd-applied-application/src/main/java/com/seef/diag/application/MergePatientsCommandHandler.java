package com.seef.diag.application;

import com.seef.diag.commons.CommandHandler;
import com.seef.diag.domain.command.MergePatientsCommand;
import com.seef.diag.domain.port.PatientRepository;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class MergePatientsCommandHandler implements CommandHandler<MergePatientsCommand> {

    private PatientRepository patientRepository;

    @Inject
    public MergePatientsCommandHandler(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public void handle(MergePatientsCommand command) {

    }
}
