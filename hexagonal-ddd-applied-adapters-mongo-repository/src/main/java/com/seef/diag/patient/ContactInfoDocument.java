package com.seef.diag.patient;

import java.util.List;

class ContactInfoDocument {

    private String email;
    private String street;
    private String number;
    private String zip;
    private String town;
    private String state;
    private String country;
    private List<PhoneNumberDocument> phoneNumbers;

    ContactInfoDocument() {
    }

    ContactInfoDocument(String email, String street, String number, String zip, String town, String state, String country, List<PhoneNumberDocument> phoneNumbers) {
        this.email = email;
        this.street = street;
        this.number = number;
        this.zip = zip;
        this.town = town;
        this.state = state;
        this.country = country;
        this.phoneNumbers = phoneNumbers;
    }

    String getEmail() {
        return email;
    }

    void setEmail(String email) {
        this.email = email;
    }

    String getStreet() {
        return street;
    }

    void setStreet(String street) {
        this.street = street;
    }

    String getNumber() {
        return number;
    }

    void setNumber(String number) {
        this.number = number;
    }

    String getZip() {
        return zip;
    }

    void setZip(String zip) {
        this.zip = zip;
    }

    String getTown() {
        return town;
    }

    void setTown(String town) {
        this.town = town;
    }

    String getState() {
        return state;
    }

    void setState(String state) {
        this.state = state;
    }

    String getCountry() {
        return country;
    }

    void setCountry(String country) {
        this.country = country;
    }

    List<PhoneNumberDocument> getPhoneNumbers() {
        return phoneNumbers;
    }

    void setPhoneNumbers(List<PhoneNumberDocument> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}
