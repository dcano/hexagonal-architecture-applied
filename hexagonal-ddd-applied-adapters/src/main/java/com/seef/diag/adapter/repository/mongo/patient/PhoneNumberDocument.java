package com.seef.diag.adapter.repository.mongo.patient;

import com.seef.diag.domain.model.PhoneType;

public class PhoneNumberDocument {

    private String number;
    private PhoneType phoneType;

    public PhoneNumberDocument() {
    }

    public PhoneNumberDocument(String number, PhoneType phoneType) {
        this.number = number;
        this.phoneType = phoneType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public PhoneType getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
    }
}
