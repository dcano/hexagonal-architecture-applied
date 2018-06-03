package com.seef.diag.patient;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patientcomments")
class CommentJpa {

    @Id
    @GeneratedValue
    private long id;
    private String comment;
    private CommentCriticality commentCriticality;

    CommentJpa() {
    }

    CommentJpa(String comment, CommentCriticality commentCriticality) {
        this.comment = comment;
        this.commentCriticality = commentCriticality;
    }

    long getId() {
        return id;
    }

    void setId(long id) {
        this.id = id;
    }

    String getComment() {
        return comment;
    }

    void setComment(String comment) {
        this.comment = comment;
    }

    CommentCriticality getCommentCriticality() {
        return commentCriticality;
    }

    void setCommentCriticality(CommentCriticality commentCriticality) {
        this.commentCriticality = commentCriticality;
    }
}
