package com.seef.diag.command;

import com.seef.diag.commons.DomainCommand;
import com.seef.diag.domain.model.ClinicalIdentifier;
import com.seef.diag.domain.model.ContactInfo;

import java.util.Date;

public class CreatePatientCommand extends DomainCommand {

    private final String firstName;
    private final String surname1;
    private final String surname2;
    private final Date birthDay;
    private final ContactInfo contactInfo;
    private final ClinicalIdentifier clinicalIdentifier;

    public CreatePatientCommand(String firstName, String surname1, String surname2, Date birthDay, ContactInfo contactInfo, String tenantId, ClinicalIdentifier clinicalIdentifier) {
        super(tenantId);
        this.firstName = firstName;
        this.surname1 = surname1;
        this.surname2 = surname2;
        this.birthDay = birthDay;
        this.contactInfo = contactInfo;
        this.clinicalIdentifier = clinicalIdentifier;
    }

    public ClinicalIdentifier getClinicalIdentifier() {
        return clinicalIdentifier;
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
