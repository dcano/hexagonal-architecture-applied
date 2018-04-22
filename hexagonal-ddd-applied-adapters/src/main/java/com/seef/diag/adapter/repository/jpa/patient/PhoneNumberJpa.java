package com.seef.diag.adapter.repository.jpa.patient;

import com.seef.diag.domain.model.PhoneType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "phonenumbers")
public class PhoneNumberJpa {

    @Id
    @GeneratedValue
    private long id;
    private String number;
    private PhoneType phoneType;

    public PhoneNumberJpa() {
    }

    public PhoneNumberJpa(String number, PhoneType phoneType) {
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
