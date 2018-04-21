package com.seef.diag.domain.model;

import com.seef.diag.commons.MultiTenantEntity;
import com.seef.diag.commons.TenantId;
import com.seef.diag.domain.event.PatientCommentAddedEvent;
import com.seef.diag.domain.event.PatientCreatedEvent;
import com.seef.diag.domain.event.PatientStatusUpdatedEvent;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Patient extends MultiTenantEntity {

    private PatientId patientId;
    private PatientName patientName;
    private ContactInfo contactInfo;
    private List<Comment> comments;
    private Date birthDate;
    private PatientStatus status;

    private Patient(PatientId patientId, PatientName patientName, ContactInfo contactInfo, List<Comment> comments, Date birthDate, TenantId tenantId, PatientStatus status) {
        super(tenantId);
        this.patientId = patientId;
        this.patientName = patientName;
        this.contactInfo = contactInfo;
        this.comments = comments;
        this.birthDate = birthDate;
        this.status = status;
    }

    public PatientId getPatientId() {
        return patientId;
    }

    public PatientName getPatientName() {
        return patientName;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public PatientStatus getStatus() {
        return status;
    }

    public void addComment(String comment, CommentCriticality commentCriticality) {
        ensureComments();
        this.comments.add(new Comment(comment, commentCriticality));
        this.publishEvent(new PatientCommentAddedEvent(comment, commentCriticality, patientId.value(), getTenantId().getId()));
        recalculateStatusFromComments();
    }

    private void recalculateStatusFromComments() {
        PatientStatus newStatus = comments.stream().filter(c -> c.getCriticality().equals(CommentCriticality.HIGH)).count() > 0 ? PatientStatus.WARNING : PatientStatus.NORMAL;;
        if(!this.status.equals(newStatus)) {
            this.publishEvent(new PatientStatusUpdatedEvent(newStatus, patientId.value(), getTenantId().getId()));
        }
        this.status = newStatus;
    }

    private void ensureComments() {
        if(this.comments == null) this.comments = new ArrayList<>();
    }

    private static Patient createNewPatient(PatientBuilder builder) {
        PatientStatus patientStatus = PatientStatus.NORMAL;
        if(builder.comments != null) {
            patientStatus = builder.comments.stream().filter(c -> c.getCriticality().equals(CommentCriticality.HIGH)).count() > 0 ? PatientStatus.WARNING : PatientStatus.NORMAL;
        }

        final Patient patient = new Patient(PatientId.of(UUID.randomUUID().toString()), PatientName.of(builder.patientName, builder.surname1, builder.surname2), builder.contactInfo, builder.comments, builder.birthDate, TenantId.of(builder.tenantId), patientStatus);
        patient.publishEvent(new PatientCreatedEvent(patient.getPatientId().value(), patient.getPatientName(), patient.getBirthDate(), patient.getContactInfo(), patient.getTenantId().getId()));
        //create events for comments
        if(patient.getComments() != null) {
            patient.getComments().stream().map(c -> new PatientCommentAddedEvent(c.getComment(), c.getCriticality(), patient.getPatientId().value(), patient.getTenantId().getId())).forEach(patient::publishEvent);
        }
        return patient;
    }

    private static Patient instanceExistingPatient(PatientBuilder builder) {
        return new Patient(PatientId.of(builder.patientId), PatientName.of(builder.patientName, builder.surname1, builder.surname2), builder.contactInfo, builder.comments, builder.birthDate, TenantId.of(builder.tenantId), builder.patientStatus);
    }

    public void incorporatePatient(Patient sourcePatient) {
        this.comments.addAll(sourcePatient.comments);
        sourcePatient.comments.stream().map(c -> new PatientCommentAddedEvent(c.getComment(), c.getCriticality(), this.patientId.value(), this.getTenantId().getId()));
    }

    public static class PatientBuilder {
        private String patientId;
        private String patientName;
        private String surname1;
        private String surname2;
        private ContactInfo contactInfo;
        private List<Comment> comments;
        private Date birthDate;
        private String tenantId;
        private PatientStatus patientStatus;

        public PatientBuilder withPatientStatus(PatientStatus patientStatus) {
            this.patientStatus = patientStatus;
            return this;
        }

        public PatientBuilder withPatientId(String patientId) {
            this.patientId = patientId;
            return this;
        }

        public PatientBuilder withPatientName(String patientName) {
            this.patientName = patientName;
            return this;
        }

        public PatientBuilder withContactInfo(ContactInfo contactInfo) {
            this.contactInfo = contactInfo;
            return this;
        }

        public PatientBuilder withComments(List<Comment> comments) {
            this.comments = comments;
            return this;
        }

        public PatientBuilder withBirthDate(Date birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public PatientBuilder withTenantId(String tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        public PatientBuilder withSurname1(String surname1) {
            this.surname1 = surname1;
            return this;
        }

        public PatientBuilder withSurname2(String surname2) {
            this.surname2 = surname2;
            return this;
        }

        public Patient createNewPatient() {
            return Patient.createNewPatient(this);
        }

        public Patient instanceExistingPatient() {
            return Patient.instanceExistingPatient(this);
        }
    }
}
