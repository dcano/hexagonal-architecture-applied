package com.seef.diag.adapter.repository.mongo.patient;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientMongoRepositoryHelper extends MongoRepository<PatientDocument, String> {

    PatientDocument findByIdAndTenantId(String id, String tenantId);
    PatientDocument findByClinicalIdentifierAndTenantId(String clinicalIdentifier, String tenantId);
    List<PatientDocument> findByPatientName_FirstNameAndPatientName_Surname1AndPatientName_Surname2AndTenantId(String firstName, String surname1, String surname2, String tenantId);

}
