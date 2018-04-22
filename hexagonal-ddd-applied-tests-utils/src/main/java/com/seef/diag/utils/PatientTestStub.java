package com.seef.diag.utils;

import com.seef.diag.domain.model.*;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PatientTestStub {

    public static Patient randomPatientForTenant(String tenantId) {
        return randomPatientForTenantWithName(tenantId, randomPatientName());
    }

    public static Patient randomPatientForTenantWithName(String tenantId, PatientName patientName) {
        Calendar birthDate = Calendar.getInstance();
        int numberOfCommentsToGenerate = Integer.parseInt(RandomStringUtils.randomNumeric(1));
        birthDate.add(Calendar.DATE, Integer.parseInt(RandomStringUtils.randomNumeric(3))*-1);
        return Patient.builder()
                .withTenantId(tenantId)
                .withPatientStatus(PatientStatus.NORMAL)
                .withPatientName(patientName.getFirstName())
                .withSurname1(patientName.getSurname1())
                .withSurname2(patientName.getSurname2())
                .withClinicalIdentifier(RandomStringUtils.randomAlphanumeric(12))
                .withBirthDate(new Date(birthDate.getTimeInMillis()))
                .withPatientId(UUID.randomUUID().toString())
                .withContactInfo(generateContactInfo())
                .withComments(generateComments(numberOfCommentsToGenerate))
                .instanceExistingPatient();
    }

    public static List<Patient> generateNumberOfPatientsForTenantWithSameName(int numberOfPatients, String tenantId) {
        return generateNumberOfPatientsForTenant(numberOfPatients, tenantId, true);
    }

    public static List<Patient> generateNumberOfPatientsForTenantWithRandomName(int numberOfPatients, String tenantId) {
        return generateNumberOfPatientsForTenant(numberOfPatients, tenantId, false);
    }

    private static List<Patient> generateNumberOfPatientsForTenant(int numberOfPatients, String tenantId, boolean sameName) {
        PatientName patientName = randomPatientName();
        return IntStream.range(0, numberOfPatients)
                .mapToObj(i -> !sameName?randomPatientForTenant(tenantId):randomPatientForTenantWithName(tenantId, patientName))
                .collect(Collectors.toList());
    }

    private static PatientName randomPatientName() {
        return PatientName.of(RandomStringUtils.randomAlphabetic(10), RandomStringUtils.randomAlphabetic(10), RandomStringUtils.randomAlphabetic(10));
    }

    private static ContactInfo generateContactInfo() {
        Address address = Address.builder()
                .withCountry(RandomStringUtils.randomAlphabetic(5))
                .withState(RandomStringUtils.randomAlphabetic(10))
                .withStreet(RandomStringUtils.randomAlphanumeric(20))
                .withTown(RandomStringUtils.randomAlphabetic(10))
                .withZip(RandomStringUtils.randomAlphanumeric(7))
                .withNumber(RandomStringUtils.randomNumeric(3))
                .build();
        List<PhoneNumber> phoneNumbers = Collections.singletonList(new PhoneNumber(RandomStringUtils.randomAlphanumeric(10), PhoneType.MOBILE));
        return new ContactInfo(phoneNumbers, address, "aa@aa.com");
    }

    private static List<Comment> generateComments(int numberOfCommentsToGenerate) {
        return IntStream.range(0, numberOfCommentsToGenerate).mapToObj(i -> new Comment(RandomStringUtils.randomAlphabetic(15), CommentCriticality.LOW)).collect(Collectors.toList());
    }

}
