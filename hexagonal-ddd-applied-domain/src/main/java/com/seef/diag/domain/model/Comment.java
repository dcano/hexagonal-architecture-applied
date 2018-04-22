package com.seef.diag.domain.model;

import com.seef.diag.commons.ValueObject;

public class Comment extends ValueObject {

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
