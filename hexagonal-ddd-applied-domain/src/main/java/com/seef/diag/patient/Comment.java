package com.seef.diag.patient;

import com.seef.diag.commons.ValueObject;

class Comment extends ValueObject {

    private final String comment;
    private final CommentCriticality criticality;

    Comment(String comment, CommentCriticality criticality) {
        this.comment = comment;
        this.criticality = criticality;
    }

    public String getComment() {
        return comment;
    }

    CommentCriticality getCriticality() {
        return criticality;
    }
}
