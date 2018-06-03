package com.seef.diag.patient;

import com.seef.diag.commons.DomainEvent;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

class PatientCommentAddedEvent extends DomainEvent {

    private final String comment;
    private final CommentCriticality commentCriticality;
    private final String patientId;

    PatientCommentAddedEvent(String comment, CommentCriticality criticality, String patientId, String tenantId) {
        super(ZonedDateTime.now(ZoneId.of("UTC")), UUID.randomUUID().toString(), tenantId);
        this.comment = comment;
        this.commentCriticality = criticality;
        this.patientId = patientId;
    }

    String getComment() {
        return comment;
    }

    CommentCriticality getCommentCriticality() {
        return commentCriticality;
    }

    String getPatientId() {
        return patientId;
    }
}
