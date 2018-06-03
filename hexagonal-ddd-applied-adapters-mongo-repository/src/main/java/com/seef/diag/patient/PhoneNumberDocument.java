package com.seef.diag.patient;

class PhoneNumberDocument {

    private String number;
    private PhoneType phoneType;

    PhoneNumberDocument() {
    }

    PhoneNumberDocument(String number, PhoneType phoneType) {
        this.number = number;
        this.phoneType = phoneType;
    }

    String getNumber() {
        return number;
    }

    void setNumber(String number) {
        this.number = number;
    }

    PhoneType getPhoneType() {
        return phoneType;
    }

    void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
    }
}
