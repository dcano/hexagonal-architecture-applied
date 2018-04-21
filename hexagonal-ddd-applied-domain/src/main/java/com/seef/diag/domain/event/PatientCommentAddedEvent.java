package com.seef.diag.domain.event;

import com.seef.diag.commons.DomainEvent;
import com.seef.diag.domain.model.CommentCriticality;
import com.seef.diag.domain.model.PatientId;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

public class PatientCommentAddedEvent extends DomainEvent {

    private final String comment;
    private final CommentCriticality commentCriticality;
    private final String patientId;

    public PatientCommentAddedEvent(String comment, CommentCriticality criticality, String patientId, String tenantId) {
        super(ZonedDateTime.now(ZoneId.of("UTC")), UUID.randomUUID().toString(), tenantId);
        this.comment = comment;
        this.commentCriticality = criticality;
        this.patientId = patientId;
    }

    public String getComment() {
        return comment;
    }

    public CommentCriticality getCommentCriticality() {
        return commentCriticality;
    }

    public String getPatientId() {
        return patientId;
    }
}
