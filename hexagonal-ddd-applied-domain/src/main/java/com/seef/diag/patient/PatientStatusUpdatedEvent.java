package com.seef.diag.patient;

import com.seef.diag.commons.DomainEvent;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

class PatientStatusUpdatedEvent extends DomainEvent {

    private final PatientStatus patientStatus;
    private final String patientId;

    PatientStatusUpdatedEvent(PatientStatus patientStatus, String patientId, String tenantId) {
        super(ZonedDateTime.now(ZoneId.of("UTC")), UUID.randomUUID().toString(), tenantId);
        this.patientId = patientId;
        this.patientStatus = patientStatus;
    }

    PatientStatus getPatientStatus() {
        return patientStatus;
    }

    String getPatientId() {
        return patientId;
    }
}
