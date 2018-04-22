package com.seef.diag.adapter.repository.jpa.patient;

import com.seef.diag.commons.TenantId;
import com.seef.diag.domain.model.ClinicalIdentifier;
import com.seef.diag.domain.model.Patient;
import com.seef.diag.domain.model.PatientId;
import com.seef.diag.domain.model.PatientName;
import com.seef.diag.domain.port.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PatientJpaRepository implements PatientRepository {

    private PatientJpaRepositoryHelper repositoryHelper;
    private PatientToJpaMapper mapper;

    @Autowired
    public PatientJpaRepository(PatientJpaRepositoryHelper patientJpaRepositoryHelper, PatientToJpaMapper mapper) {
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
