package com.seef.diag.patient;

import com.seef.diag.commons.ValueObject;

class ClinicalIdentifier extends ValueObject {

    private final String clinicalIdentifier;

    private ClinicalIdentifier(String clinicalIdentifier) {
        this.clinicalIdentifier = clinicalIdentifier;
    }

    public String value() {
        return clinicalIdentifier;
    }

    static ClinicalIdentifier of(String clinicalIdentifier) {
        return new ClinicalIdentifier(clinicalIdentifier);
    }
}
