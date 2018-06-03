package com.seef.diag.patient;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "patients",
        indexes = {
                @Index(name = "tenantid_patientid", columnList = "tenantId, id")
        },
        uniqueConstraints = {
                @UniqueConstraint(name = "tenantId_clinicalIdentifier", columnNames = {"tenantId", "clinicalIdentifier"})
        })
class PatientJpa {

    @Id
    private String id;
    private String clinicalIdentifier;
    private String patientName;
    private String surname1;
    private String surname2;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private ContactInfoJpa contactInfo;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private List<CommentJpa> comments;
    private Date birthDate;
    private String tenantId;
    private PatientStatus patientStatus;

    String getId() {
        return id;
    }

    void setId(String id) {
        this.id = id;
    }

    String getClinicalIdentifier() {
        return clinicalIdentifier;
    }

    void setClinicalIdentifier(String clinicalIdentifier) {
        this.clinicalIdentifier = clinicalIdentifier;
    }

    String getPatientName() {
        return patientName;
    }

    void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    String getSurname1() {
        return surname1;
    }

    void setSurname1(String surname1) {
        this.surname1 = surname1;
    }

    String getSurname2() {
        return surname2;
    }

    void setSurname2(String surname2) {
        this.surname2 = surname2;
    }

    ContactInfoJpa getContactInfo() {
        return contactInfo;
    }

    void setContactInfo(ContactInfoJpa contactInfo) {
        this.contactInfo = contactInfo;
    }

    List<CommentJpa> getComments() {
        return comments;
    }

    void setComments(List<CommentJpa> comments) {
        this.comments = comments;
    }

    Date getBirthDate() {
        return birthDate;
    }

    void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    String getTenantId() {
        return tenantId;
    }

    void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    PatientStatus getPatientStatus() {
        return patientStatus;
    }

    void setPatientStatus(PatientStatus patientStatus) {
        this.patientStatus = patientStatus;
    }
}
