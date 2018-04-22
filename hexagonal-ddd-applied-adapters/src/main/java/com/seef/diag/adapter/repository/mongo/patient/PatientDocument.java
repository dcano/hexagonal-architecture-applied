package com.seef.diag.adapter.repository.mongo.patient;

import com.seef.diag.domain.model.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "seef.patients")
@CompoundIndexes({
        @CompoundIndex(name = "tenantId_id", def = "{'tenantId' : 1, '_id' : 1}"),
        @CompoundIndex(name = "clinical_identifier_tenant_id", def = "{'tenantId' : 1, 'clinicalIdentifier' : 1}", unique = true)
})
public class PatientDocument {

    @Id
    private String id;
    private PatientName patientName;
    private ContactInfo contactInfo;
    private List<Comment> comments;
    private Date birthDay;
    private PatientStatus status;
    private String clinicalIdentifier;
    private String tenantId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PatientName getPatientName() {
        return patientName;
    }

    public void setPatientName(PatientName patientName) {
        this.patientName = patientName;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public PatientStatus getStatus() {
        return status;
    }

    public void setStatus(PatientStatus status) {
        this.status = status;
    }

    public String getClinicalIdentifier() {
        return clinicalIdentifier;
    }

    public void setClinicalIdentifier(String clinicalIdentifier) {
        this.clinicalIdentifier = clinicalIdentifier;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
}
