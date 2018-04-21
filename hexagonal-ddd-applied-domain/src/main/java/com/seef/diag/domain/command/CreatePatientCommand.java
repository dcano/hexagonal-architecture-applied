package com.seef.diag.domain.command;

import com.seef.diag.domain.model.Comment;
import com.seef.diag.domain.model.ContactInfo;

import java.util.Date;
import java.util.List;

public class CreatePatientCommand {

    private final String firstName;
    private final String surname1;
    private final String surname2;
    private final Date birthDay;
    private final ContactInfo contactInfo;

    public CreatePatientCommand(String firstName, String surname1, String surname2, Date birthDay, ContactInfo contactInfo) {
        this.firstName = firstName;
        this.surname1 = surname1;
        this.surname2 = surname2;
        this.birthDay = birthDay;
        this.contactInfo = contactInfo;
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

    public Date getBirthDay() {
        return birthDay;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }
}
