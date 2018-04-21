package com.seef.diag.domain.model;

public class Comment {
    private final String comment;
    private final CommentCriticality criticality;

    public Comment(String comment, CommentCriticality criticality) {
        this.comment = comment;
        this.criticality = criticality;
    }

    public String getComment() {
        return comment;
    }

    public CommentCriticality getCriticality() {
        return criticality;
    }
}
