package com.seef.diag.adapter.repository.jpa.patient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "contactinfo")
public class ContactInfoJpa {

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

    public ContactInfoJpa() {
    }

    public ContactInfoJpa(String street, String number, String zip, String town, String state, String country, String email, List<PhoneNumberJpa> phoneNumberJpas) {
        this.street = street;
        this.number = number;
        this.zip = zip;
        this.town = town;
        this.state = state;
        this.country = country;
        this.email = email;
        this.phoneNumbers = phoneNumberJpas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<PhoneNumberJpa> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumberJpa> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}
