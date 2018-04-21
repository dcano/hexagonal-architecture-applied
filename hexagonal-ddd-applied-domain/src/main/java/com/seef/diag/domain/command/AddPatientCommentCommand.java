package com.seef.diag.domain.command;

import com.seef.diag.domain.model.CommentCriticality;

public class AddPatientCommentCommand {

    private final String patientId;
    private final String comment;
    private final CommentCriticality commentCriticality;
    private final String tenantId;

    public AddPatientCommentCommand(String patientId, String comment, CommentCriticality commentCriticality, String tenantId) {
        this.patientId = patientId;
        this.comment = comment;
        this.commentCriticality = commentCriticality;
        this.tenantId = tenantId;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getComment() {
        return comment;
    }

    public CommentCriticality getCommentCriticality() {
        return commentCriticality;
    }

    public String getTenantId() {
        return tenantId;
    }
}
