package com.seef.diag.domain.port;

import com.seef.diag.commons.DomainCommand;
import com.seef.diag.domain.model.Patient;

import java.util.List;

public interface PatientOutputPort {
    void write(Patient patient, DomainCommand domainCommand);
    void write(List<Patient> patients);
}
