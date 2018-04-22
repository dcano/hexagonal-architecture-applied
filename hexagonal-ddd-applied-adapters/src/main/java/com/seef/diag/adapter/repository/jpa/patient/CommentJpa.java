package com.seef.diag.adapter.repository.jpa.patient;

import com.seef.diag.domain.model.CommentCriticality;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patientcomments")
public class CommentJpa {

    @Id
    @GeneratedValue
    private long id;
    private String comment;
    private CommentCriticality commentCriticality;

    public CommentJpa() {
    }

    public CommentJpa(String comment, CommentCriticality commentCriticality) {
        this.comment = comment;
        this.commentCriticality = commentCriticality;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public CommentCriticality getCommentCriticality() {
        return commentCriticality;
    }

    public void setCommentCriticality(CommentCriticality commentCriticality) {
        this.commentCriticality = commentCriticality;
    }
}
