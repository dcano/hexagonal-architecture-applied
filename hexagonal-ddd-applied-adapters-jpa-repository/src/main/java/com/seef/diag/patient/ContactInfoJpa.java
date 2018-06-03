package com.seef.diag.patient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "contactinfo")
class ContactInfoJpa {

    @Id
    @GeneratedValue
    private long id;
    private String street;
    private String number;
    private String zip;
    private String town;
    private String state;
    private String country;
    private String email;

    @OneToMany(cascade = {CascadeType.ALL})
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<PhoneNumberJpa> phoneNumbers;

    ContactInfoJpa() {
    }

    ContactInfoJpa(String street, String number, String zip, String town, String state, String country, String email, List<PhoneNumberJpa> phoneNumberJpas) {
        this.street = street;
        this.number = number;
        this.zip = zip;
        this.town = town;
        this.state = state;
        this.country = country;
        this.email = email;
        this.phoneNumbers = phoneNumberJpas;
    }

    long getId() {
        return id;
    }

    void setId(long id) {
        this.id = id;
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

    String getEmail() {
        return email;
    }

    void setEmail(String email) {
        this.email = email;
    }

    List<PhoneNumberJpa> getPhoneNumbers() {
        return phoneNumbers;
    }

    void setPhoneNumbers(List<PhoneNumberJpa> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}
