package com.seef.diag.domain.model;

import com.seef.diag.commons.ValueObject;

public class PatientName extends ValueObject {

    private final String firstName;
    private final String surname1;
    private final String surname2;

    private PatientName(String patientName, String surname1, String surname2) {
        this.firstName = patientName;
        this.surname1 = surname1;
        this.surname2 = surname2;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname1() {
        return surname1;
    }

    public String getSurname2() {
        return surname2;
    }

    public static PatientName of(String patientName, String surname1, String surname2) {
        return new PatientName(patientName, surname1, surname2);
    }

}
