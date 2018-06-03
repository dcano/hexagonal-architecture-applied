package com.seef.diag.patient;

import com.seef.diag.commons.DomainCommand;

public class AddPatientCommentCommand extends DomainCommand {

    private final String patientId;
    private final String comment;
    private final CommentCriticality commentCriticality;

    public AddPatientCommentCommand(String patientId, String comment, CommentCriticality commentCriticality, String tenantId) {
        super(tenantId);
        this.patientId = patientId;
        this.comment = comment;
        this.commentCriticality = commentCriticality;
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

}
