package com.seef.diag.adapter.repository.jpa.patient;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientJpaRepositoryHelper extends CrudRepository<PatientJpa, String> {

    PatientJpa findByIdAndTenantId(String id, String tenantId);
    PatientJpa findByClinicalIdentifierAndTenantId(String clinicalIdentifier, String tenantId);
    List<PatientJpa> findByPatientNameAndSurname1AndSurname2AndTenantId(String firstName, String surname1, String surname2, String tenantId);


}
