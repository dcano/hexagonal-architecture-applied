package com.seef.diag.domain.model;

import com.seef.diag.commons.ValueObject;

public class PatientId extends ValueObject {

    private final String patientId;

    public PatientId(String patientId) {
        this.patientId = patientId;
    }

    public static PatientId of(String patientId) {
        return new PatientId(patientId);
    }

    public String value() {
        return patientId;
    }
}
