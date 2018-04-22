package com.seef.diag.adapter.repository.mongo;

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
public class PatientMongoRepository implements PatientRepository {

    private PatientToDocumentMapper patientToDocumentMapper;
    private PatientMongoRepositoryHelper helper;

    @Autowired
    public PatientMongoRepository(PatientToDocumentMapper patientToDocumentMapper, PatientMongoRepositoryHelper helper) {
        this.patientToDocumentMapper = patientToDocumentMapper;
        this.helper = helper;
    }

    @Override
    public Patient save(Patient patient) {
        return patientToDocumentMapper
                .toDomain(helper.save(patientToDocumentMapper
                        .toDocument(patient)));
    }

    @Override
    public Patient findOneBy(PatientId patientId, TenantId tenantId) {
        return patientToDocumentMapper.toDomain(helper.findByIdAndTenantId(patientId.value(), tenantId.getId()));
    }

    @Override
    public Patient findOneBy(ClinicalIdentifier clinicalIdentifier, TenantId tenantId) {
        return patientToDocumentMapper.toDomain(helper.findByClinicalIdentifierAndTenantId(clinicalIdentifier.value(), tenantId.getId()));
    }

    @Override
    public List<Patient> findPatientsMatching(PatientName patientName, TenantId tenantId) {
        return helper.findByPatientName_FirstNameAndPatientName_Surname1AndPatientName_Surname2AndTenantId(patientName.getFirstName(), patientName.getSurname1(), patientName.getSurname2(), tenantId.getId())
                .stream()
                .map(patientToDocumentMapper::toDomain)
                .collect(Collectors.toList());
    }
}
