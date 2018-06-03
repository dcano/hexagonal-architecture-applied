package com.seef.diag.patient;

import com.seef.diag.commons.DomainCommand;
import com.seef.diag.patient.Patient;

import java.util.List;

public interface PatientOutputPort {
    void write(Patient patient, DomainCommand domainCommand);
    void write(List<Patient> patients);
}
