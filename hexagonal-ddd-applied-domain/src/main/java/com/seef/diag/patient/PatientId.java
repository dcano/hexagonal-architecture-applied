package com.seef.diag.patient;

import com.seef.diag.commons.ValueObject;

class PatientId extends ValueObject {

    private final String patientId;

    PatientId(String patientId) {
        this.patientId = patientId;
    }

    static PatientId of(String patientId) {
        return new PatientId(patientId);
    }

    String value() {
        return patientId;
    }
}
