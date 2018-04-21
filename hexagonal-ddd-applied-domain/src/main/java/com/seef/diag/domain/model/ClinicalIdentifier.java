package com.seef.diag.domain.model;

import com.seef.diag.commons.ValueObject;

public class ClinicalIdentifier extends ValueObject {

    private final String clinicalIdentifier;

    private ClinicalIdentifier(String clinicalIdentifier) {
        this.clinicalIdentifier = clinicalIdentifier;
    }

    public String value() {
        return clinicalIdentifier;
    }

    public static ClinicalIdentifier of(String clinicalIdentifier) {
        return new ClinicalIdentifier(clinicalIdentifier);
    }
}
