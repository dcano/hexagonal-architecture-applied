package com.seef.diag.patient;

class PatientNameDocument {

    private String firstName;
    private String surname1;
    private String surname2;

    PatientNameDocument() {
    }

    PatientNameDocument(String firstName, String surname1, String surname2) {
        this.firstName = firstName;
        this.surname1 = surname1;
        this.surname2 = surname2;
    }

    String getFirstName() {
        return firstName;
    }

    void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    String getSurname1() {
        return surname1;
    }

    void setSurname1(String surname1) {
        this.surname1 = surname1;
    }

    String getSurname2() {
        return surname2;
    }

    public void setSurname2(String surname2) {
        this.surname2 = surname2;
    }
}
