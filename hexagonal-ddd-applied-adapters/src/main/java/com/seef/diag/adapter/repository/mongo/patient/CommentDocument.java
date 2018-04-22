package com.seef.diag.adapter.repository.mongo.patient;

import com.seef.diag.domain.model.CommentCriticality;

public class CommentDocument {

    private String comment;
    private CommentCriticality criticality;

    public CommentDocument(String comment, CommentCriticality criticality) {
        this.comment = comment;
        this.criticality = criticality;
    }

    public CommentDocument() {
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public CommentCriticality getCriticality() {
        return criticality;
    }

    public void setCriticality(CommentCriticality criticality) {
        this.criticality = criticality;
    }
}
