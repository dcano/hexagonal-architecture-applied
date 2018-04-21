package com.seef.diag.domain.model;

import com.seef.diag.commons.MultiTenantEntity;
import com.seef.diag.commons.TenantId;
import com.seef.diag.domain.event.PatientCommentAddedEvent;
import com.seef.diag.domain.event.PatientCreatedEvent;
import com.seef.diag.domain.event.PatientStatusUpdatedEvent;

import java.util.*;

public class Patient extends MultiTenantEntity {

    private PatientId patientId;
    private PatientName patientName;
    private ContactInfo contactInfo;
    private List<Comment> comments;
    private Date birthDay;
    private PatientStatus status;
    private ClinicalIdentifier clinicalIdentifier;

    private Patient(PatientId patientId, PatientName patientName, ContactInfo contactInfo, List<Comment> comments, Date birthDay, TenantId tenantId, PatientStatus status, ClinicalIdentifier clinicalIdentifier) {
        super(tenantId);
        this.patientId = patientId;
        this.patientName = patientName;
        this.contactInfo = contactInfo;
        this.comments = comments;
        this.birthDay = birthDay;
        this.status = status;
        this.clinicalIdentifier = clinicalIdentifier;
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
        return Collections.unmodifiableList(comments);
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public PatientStatus getStatus() {
        return status;
    }

    public ClinicalIdentifier getClinicalIdentifier() {
        return clinicalIdentifier;
    }

    public void addComment(String comment, CommentCriticality commentCriticality) {
        ensureComments();
        this.comments.add(new Comment(comment, commentCriticality));
        this.publishEvent(new PatientCommentAddedEvent(comment, commentCriticality, patientId.value(), getTenantId().getId()));
        recalculateStatusFromComments();
    }

    public void incorporatePatient(Patient sourcePatient) {
        ensureComments();
        this.comments.addAll(sourcePatient.comments);
        sourcePatient.comments.stream().map(c -> new PatientCommentAddedEvent(c.getComment(), c.getCriticality(), this.patientId.value(), this.getTenantId().getId()));
    }

    public static PatientBuilder builder() {
        return new PatientBuilder();
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
        final Patient patient = new Patient(PatientId.of(UUID.randomUUID().toString()), PatientName.of(builder.patientName, builder.surname1, builder.surname2), builder.contactInfo, null, builder.birthDate, TenantId.of(builder.tenantId), patientStatus, ClinicalIdentifier.of(builder.clinicalIdentifier));
        patient.publishEvent(new PatientCreatedEvent(patient.getPatientId().value(), patient.getPatientName(), patient.getBirthDay(), patient.getContactInfo(), patient.getTenantId().getId()));
        return patient;
    }

    private static Patient instanceExistingPatient(PatientBuilder builder) {
        return new Patient(PatientId.of(builder.patientId), PatientName.of(builder.patientName, builder.surname1, builder.surname2), builder.contactInfo, builder.comments, builder.birthDate, TenantId.of(builder.tenantId), builder.patientStatus, ClinicalIdentifier.of(builder.clinicalIdentifier));
    }


    public static class PatientBuilder {
        private String clinicalIdentifier;
        private String patientId;
        private String patientName;
        private String surname1;
        private String surname2;
        private ContactInfo contactInfo;
        private List<Comment> comments;
        private Date birthDate;
        private String tenantId;
        private PatientStatus patientStatus;

        public PatientBuilder withClinicalIdentifier(String clinicalIdentifier) {
            this.clinicalIdentifier = clinicalIdentifier;
            return this;
        }

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
