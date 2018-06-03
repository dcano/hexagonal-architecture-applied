package com.seef.diag.patient;

class CommentDocument {

    private String comment;
    private CommentCriticality criticality;

    CommentDocument(String comment, CommentCriticality criticality) {
        this.comment = comment;
        this.criticality = criticality;
    }

    CommentDocument() {
    }

    String getComment() {
        return comment;
    }

    void setComment(String comment) {
        this.comment = comment;
    }

    CommentCriticality getCriticality() {
        return criticality;
    }

    void setCriticality(CommentCriticality criticality) {
        this.criticality = criticality;
    }
}
