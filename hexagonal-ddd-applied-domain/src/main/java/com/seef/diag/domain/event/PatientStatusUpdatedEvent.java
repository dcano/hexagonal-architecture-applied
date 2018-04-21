package com.seef.diag.domain.event;

import com.seef.diag.commons.DomainEvent;
import com.seef.diag.domain.model.Patient;
import com.seef.diag.domain.model.PatientStatus;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

public class PatientStatusUpdatedEvent extends DomainEvent {

    private final PatientStatus patientStatus;
    private final String patientId;

    public PatientStatusUpdatedEvent(PatientStatus patientStatus, String patientId, String tenantId) {
        super(ZonedDateTime.now(ZoneId.of("UTC")), UUID.randomUUID().toString(), tenantId);
        this.patientId = patientId;
        this.patientStatus = patientStatus;
    }

    public PatientStatus getPatientStatus() {
        return patientStatus;
    }

    public String getPatientId() {
        return patientId;
    }
}
