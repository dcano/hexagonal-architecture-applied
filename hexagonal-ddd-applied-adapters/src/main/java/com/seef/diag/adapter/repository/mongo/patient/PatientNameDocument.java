package com.seef.diag.adapter.repository.mongo.patient;

public class PatientNameDocument {

    private String firstName;
    private String surname1;
    private String surname2;

    public PatientNameDocument() {
    }

    public PatientNameDocument(String firstName, String surname1, String surname2) {
        this.firstName = firstName;
        this.surname1 = surname1;
        this.surname2 = surname2;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname1() {
        return surname1;
    }

    public void setSurname1(String surname1) {
        this.surname1 = surname1;
    }

    public String getSurname2() {
        return surname2;
    }

    public void setSurname2(String surname2) {
        this.surname2 = surname2;
    }
}
