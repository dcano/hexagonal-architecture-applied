package com.seef.diag.adapter.repository.jpa.patient;

import com.seef.diag.domain.model.PatientStatus;

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
public class PatientJpa {

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClinicalIdentifier() {
        return clinicalIdentifier;
    }

    public void setClinicalIdentifier(String clinicalIdentifier) {
        this.clinicalIdentifier = clinicalIdentifier;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getSurname1() {
        return surname1;
    }

    public void setSurname1(String surname1) {
        this.surname1 = surname1;
    }

    public String getSurname2() {
        return surname2;
    }

    public void setSurname2(String surname2) {
        this.surname2 = surname2;
    }

    public ContactInfoJpa getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfoJpa contactInfo) {
        this.contactInfo = contactInfo;
    }

    public List<CommentJpa> getComments() {
        return comments;
    }

    public void setComments(List<CommentJpa> comments) {
        this.comments = comments;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public PatientStatus getPatientStatus() {
        return patientStatus;
    }

    public void setPatientStatus(PatientStatus patientStatus) {
        this.patientStatus = patientStatus;
    }
}
