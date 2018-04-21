package com.seef.diag.domain.model;

import com.seef.diag.commons.ValueObject;

public class PhoneNumber extends ValueObject {

    private final String number;
    private final PhoneType phoneType;

    public PhoneNumber(String number, PhoneType phoneType) {
        this.number = number;
        this.phoneType = phoneType;
    }

    public String getNumber() {
        return number;
    }

    public PhoneType getPhoneType() {
        return phoneType;
    }
}
