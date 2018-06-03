package com.seef.diag.patient;

import com.seef.diag.commons.CommandHandler;
import com.seef.diag.commons.TenantId;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CreatePatientCommandHandler implements CommandHandler<CreatePatientCommand> {

    private PatientRepository patientRepository;
    private PatientOutputPort patientOutputPort;

    @Inject
    public CreatePatientCommandHandler(PatientRepository patientRepository, PatientOutputPort patientOutputPort) {
        this.patientRepository = patientRepository;
        this.patientOutputPort = patientOutputPort;
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
        patientOutputPort.write(patient, command);
    }
}
