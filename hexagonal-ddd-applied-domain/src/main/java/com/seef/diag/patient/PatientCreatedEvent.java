package com.seef.diag.patient;

import com.seef.diag.commons.DomainEvent;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;

class PatientCreatedEvent extends DomainEvent {

    private final String patientId;
    private final PatientName patientName;
    private final Date birthDate;
    private final ContactInfo contactInfo;

    PatientCreatedEvent(String patientId, PatientName patientName, Date birthDate, ContactInfo contactInfo, String tenantId) {
        super(ZonedDateTime.now(ZoneId.of("UTC")), UUID.randomUUID().toString(), tenantId);
        this.patientId = patientId;
        this.patientName = patientName;
        this.birthDate = birthDate;
        this.contactInfo = contactInfo;
    }

    String getPatientId() {
        return patientId;
    }

    PatientName getPatientName() {
        return patientName;
    }

    Date getBirthDate() {
        return birthDate;
    }

    ContactInfo getContactInfo() {
        return contactInfo;
    }
}
