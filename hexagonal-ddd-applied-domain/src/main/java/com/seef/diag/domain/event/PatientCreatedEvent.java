package com.seef.diag.domain.event;

import com.seef.diag.commons.DomainEvent;
import com.seef.diag.domain.model.ContactInfo;
import com.seef.diag.domain.model.PatientName;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;

public class PatientCreatedEvent extends DomainEvent {

    private final String patientId;
    private final PatientName patientName;
    private final Date birthDate;
    private final ContactInfo contactInfo;

    public PatientCreatedEvent(String patientId, PatientName patientName, Date birthDate, ContactInfo contactInfo, String tenantId) {
        super(ZonedDateTime.now(ZoneId.of("UTC")), UUID.randomUUID().toString(), tenantId);
        this.patientId = patientId;
        this.patientName = patientName;
        this.birthDate = birthDate;
        this.contactInfo = contactInfo;
    }

    public String getPatientId() {
        return patientId;
    }

    public PatientName getPatientName() {
        return patientName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }
}
