package com.seef.diag.adapter.repository.mongo.patient;

import com.seef.diag.domain.model.PhoneNumber;

import java.util.List;

public class ContactInfoDocument {

    private String email;
    private String street;
    private String number;
    private String zip;
    private String town;
    private String state;
    private String country;
    private List<PhoneNumberDocument> phoneNumbers;

    public ContactInfoDocument() {
    }

    public ContactInfoDocument(String email, String street, String number, String zip, String town, String state, String country, List<PhoneNumberDocument> phoneNumbers) {
        this.email = email;
        this.street = street;
        this.number = number;
        this.zip = zip;
        this.town = town;
        this.state = state;
        this.country = country;
        this.phoneNumbers = phoneNumbers;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<PhoneNumberDocument> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumberDocument> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}
