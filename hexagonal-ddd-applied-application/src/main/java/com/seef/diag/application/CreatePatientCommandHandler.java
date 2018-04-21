package com.seef.diag.application;

import com.seef.diag.commons.CommandHandler;
import com.seef.diag.commons.TenantId;
import com.seef.diag.domain.command.CreatePatientCommand;
import com.seef.diag.domain.model.Patient;
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
    public void handle(CreatePatientCommand command) {
        //check if patient with clinical identifier already exists
        Patient patient = patientRepository.findOneBy(command.getClinicalIdentifier(), TenantId.of(command.tenantId()));
        if(patient != null) {
            throw new IllegalStateException("Patient with id " + command.getClinicalIdentifier().value() + " already exists.");
        }

        patient = Patient.builder()
                .withPatientName(command.getFirstName())
                .withSurname1(command.getSurname1())
                .withSurname2(command.getSurname2())
                .withBirthDate(command.getBirthDay())
                .withClinicalIdentifier(command.getClinicalIdentifier().value())
                .withContactInfo(command.getContactInfo())
                .createNewPatient();

        patientRepository.save(patient);
    }
}
