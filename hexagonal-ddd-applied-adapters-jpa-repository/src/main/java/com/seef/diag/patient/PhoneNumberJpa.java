package com.seef.diag.patient;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "phonenumbers")
class PhoneNumberJpa {

    @Id
    @GeneratedValue
    private long id;
    private String number;
    private PhoneType phoneType;

    PhoneNumberJpa() {
    }

    PhoneNumberJpa(String number, PhoneType phoneType) {
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

    long getId() {
        return id;
    }

    void setId(long id) {
        this.id = id;
    }
}
