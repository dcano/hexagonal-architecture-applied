package com.seef.diag.domain.port;

import com.seef.diag.domain.model.Patient;

public interface PatientOutputPort {
    void write(Patient patient);
}
