package com.seef.diag.patient;

import com.seef.diag.commons.TenantId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
class PatientJpaRepository implements PatientRepository {

    private PatientJpaRepositoryHelper repositoryHelper;
    private PatientToJpaMapper mapper;

    @Autowired
    PatientJpaRepository(PatientJpaRepositoryHelper patientJpaRepositoryHelper, PatientToJpaMapper mapper) {
        this.repositoryHelper = patientJpaRepositoryHelper;
        this.mapper = mapper;
    }

    @Override
    public Patient save(Patient patient) {
        return mapper.toDomain(repositoryHelper.save(mapper.toJpa(patient)));
    }

    @Override
    public Patient findOneBy(PatientId patientId, TenantId tenantId) {
        return mapper.toDomain(repositoryHelper.findByIdAndTenantId(patientId.value(), tenantId.getId()));
    }

    @Override
    public Patient findOneBy(ClinicalIdentifier clinicalIdentifier, TenantId tenantId) {
        return mapper.toDomain(repositoryHelper.findByClinicalIdentifierAndTenantId(clinicalIdentifier.value(), tenantId.getId()));
    }

    @Override
    public List<Patient> findPatientsMatching(PatientName patientName, TenantId tenantId) {
        return repositoryHelper.findByPatientNameAndSurname1AndSurname2AndTenantId(patientName.getFirstName(), patientName.getSurname1(), patientName.getSurname2(), tenantId.getId())
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
}
