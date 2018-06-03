package com.seef.diag.patient;

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
class PatientDocument {

    @Id
    private String id;
    private PatientNameDocument patientName;
    private ContactInfoDocument contactInfo;
    private List<CommentDocument> comments;
    private Date birthDay;
    private PatientStatus status;
    private String clinicalIdentifier;
    private String tenantId;

    String getId() {
        return id;
    }

    void setId(String id) {
        this.id = id;
    }

    PatientNameDocument getPatientName() {
        return patientName;
    }

    void setPatientName(PatientNameDocument patientName) {
        this.patientName = patientName;
    }

    ContactInfoDocument getContactInfo() {
        return contactInfo;
    }

    void setContactInfo(ContactInfoDocument contactInfo) {
        this.contactInfo = contactInfo;
    }

    List<CommentDocument> getComments() {
        return comments;
    }

    void setComments(List<CommentDocument> comments) {
        this.comments = comments;
    }

    Date getBirthDay() {
        return birthDay;
    }

    void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    PatientStatus getStatus() {
        return status;
    }

    void setStatus(PatientStatus status) {
        this.status = status;
    }

    String getClinicalIdentifier() {
        return clinicalIdentifier;
    }

    void setClinicalIdentifier(String clinicalIdentifier) {
        this.clinicalIdentifier = clinicalIdentifier;
    }

    String getTenantId() {
        return tenantId;
    }

    void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
}
