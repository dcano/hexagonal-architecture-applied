package com.seef.diag.patient;

import com.seef.diag.commons.ValueObject;

class PhoneNumber extends ValueObject {

    private final String number;
    private final PhoneType phoneType;

    PhoneNumber(String number, PhoneType phoneType) {
        this.number = number;
        this.phoneType = phoneType;
    }

    String getNumber() {
        return number;
    }

    PhoneType getPhoneType() {
        return phoneType;
    }
}
