package com.seef.diag.patient;

import com.seef.diag.patient.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.assertj.core.api.WithAssertions;
import org.junit.Test;

import java.util.Collections;
import java.util.UUID;
import java.util.stream.Collectors;

public class PatientTest implements WithAssertions {

    @Test
    public void createNewPatientWithoutComments() {
        Patient patient = Patient.builder()
                .withTenantId(UUID.randomUUID().toString())
                .withPatientStatus(PatientStatus.NORMAL)
                .withClinicalIdentifier(RandomStringUtils.randomAlphanumeric(10))
                .withBirthDate(new java.util.Date())
                .withPatientName(RandomStringUtils.randomAlphabetic(10))
                .withSurname1(RandomStringUtils.randomAlphabetic(10))
                .withSurname2(RandomStringUtils.randomAlphabetic(10))
                .withContactInfo(new ContactInfo(Collections.singletonList(new PhoneNumber(RandomStringUtils.randomAlphanumeric(10), PhoneType.MOBILE)), Address.builder()
                        .withStreet(RandomStringUtils.randomAlphanumeric(15))
                        .withNumber(RandomStringUtils.randomNumeric(3))
                        .withCountry(RandomStringUtils.randomAlphabetic(10))
                        .withState(RandomStringUtils.randomAlphabetic(10))
                        .withZip(RandomStringUtils.randomAlphanumeric(5))
                        .build(), "aa@aa.com"))
                .createNewPatient();
        assertThat(patient).as("Patient is not null").isNotNull();
        assertThat(patient.getDomainEvents().size()).as("Expected number of events").isEqualTo(1);
        assertThat(patient.getDomainEvents().get(0).getClass().getSimpleName()).as("Event is of expected type").isEqualTo(PatientCreatedEvent.class.getSimpleName());
        //TODO add more asserts
    }

    @Test
    public void instanceExistingPatient() {
        Patient patient = Patient.builder()
                .withPatientId(UUID.randomUUID().toString())
                .withTenantId(UUID.randomUUID().toString())
                .withPatientStatus(PatientStatus.NORMAL)
                .withClinicalIdentifier(RandomStringUtils.randomAlphanumeric(10))
                .withBirthDate(new java.util.Date())
                .withPatientName(RandomStringUtils.randomAlphabetic(10))
                .withSurname1(RandomStringUtils.randomAlphabetic(10))
                .withSurname2(RandomStringUtils.randomAlphabetic(10))
                .withContactInfo(new ContactInfo(Collections.singletonList(new PhoneNumber(RandomStringUtils.randomAlphanumeric(10), PhoneType.MOBILE)), Address.builder()
                        .withStreet(RandomStringUtils.randomAlphanumeric(15))
                        .withNumber(RandomStringUtils.randomNumeric(3))
                        .withCountry(RandomStringUtils.randomAlphabetic(10))
                        .withState(RandomStringUtils.randomAlphabetic(10))
                        .withZip(RandomStringUtils.randomAlphanumeric(5))
                        .build(), "aa@aa.com"))
                .instanceExistingPatient();
        assertThat(patient).as("Patient is not null").isNotNull();
        assertThat(patient.getDomainEvents().size()).as("Expected number of events").isEqualTo(0);

    }

    @Test
    public void addCommentToPatient() {
        Patient patient = randomExistingPatient();
        String commentText = RandomStringUtils.randomAlphabetic(150);
        patient.addComment(commentText, CommentCriticality.LOW);
        assertThat(patient.getComments()).as("Comment list is not null").isNotNull();
        assertThat(patient.getComments().size()).as("Comment has expected size").isEqualTo(1);
        assertThat(patient.getDomainEvents().size()).as("Entity has one event").isEqualTo(1);
        assertThat(patient.getDomainEvents().stream().filter(e -> e.getClass().getSimpleName().equals(PatientCommentAddedEvent.class.getSimpleName())).collect(Collectors.toList()).size()).as("Entity has CommentAddedEvent").isEqualTo(1);
        assertThat(((PatientCommentAddedEvent)patient.getDomainEvents().get(0)).getComment()).as("Event has expected comment").isEqualTo(commentText);
        assertThat(((PatientCommentAddedEvent)patient.getDomainEvents().get(0)).getCommentCriticality()).as("Event has expected comment criticality").isEqualTo(CommentCriticality.LOW);
        assertThat(((PatientCommentAddedEvent)patient.getDomainEvents().get(0)).getPatientId()).as("Event has expected patient id").isEqualTo(patient.getPatientId().value());
    }

    @Test
    public void addHighPriorityCommentToPatient() {
        Patient patient = randomExistingPatient();
        String commentText = RandomStringUtils.randomAlphabetic(150);
        patient.addComment(commentText, CommentCriticality.HIGH);
        assertThat(patient.getComments()).as("Comment list is not null").isNotNull();
        assertThat(patient.getComments().size()).as("Comment has expected size").isEqualTo(1);
        assertThat(patient.getDomainEvents().size()).as("Entity has two event").isEqualTo(2);
        assertThat(patient.getDomainEvents().stream().filter(e -> e.getClass().getSimpleName().equals(PatientCommentAddedEvent.class.getSimpleName())).collect(Collectors.toList()).size()).as("Entity has one CommentAddedEvent").isEqualTo(1);
        assertThat(patient.getDomainEvents().stream().filter(e -> e.getClass().getSimpleName().equals(PatientStatusUpdatedEvent.class.getSimpleName())).collect(Collectors.toList()).size()).as("Entity has one PatientStatusUpdatedEvent").isEqualTo(1);
        assertThat(((PatientCommentAddedEvent)patient.getDomainEvents().get(0)).getComment()).as("Event has expected comment").isEqualTo(commentText);
        assertThat(((PatientCommentAddedEvent)patient.getDomainEvents().get(0)).getCommentCriticality()).as("Event has expected comment criticality").isEqualTo(CommentCriticality.HIGH);
        assertThat(((PatientCommentAddedEvent)patient.getDomainEvents().get(0)).getPatientId()).as("Event has expected patient id").isEqualTo(patient.getPatientId().value());
    }

    private static Patient randomExistingPatient() {
        return Patient.builder()
                .withPatientId(UUID.randomUUID().toString())
                .withTenantId(UUID.randomUUID().toString())
                .withPatientStatus(PatientStatus.NORMAL)
                .withClinicalIdentifier(RandomStringUtils.randomAlphanumeric(10))
                .withBirthDate(new java.util.Date())
                .withPatientName(RandomStringUtils.randomAlphabetic(10))
                .withSurname1(RandomStringUtils.randomAlphabetic(10))
                .withSurname2(RandomStringUtils.randomAlphabetic(10))
                .withContactInfo(new ContactInfo(Collections.singletonList(new PhoneNumber(RandomStringUtils.randomAlphanumeric(10), PhoneType.MOBILE)), Address.builder()
                        .withStreet(RandomStringUtils.randomAlphanumeric(15))
                        .withNumber(RandomStringUtils.randomNumeric(3))
                        .withCountry(RandomStringUtils.randomAlphabetic(10))
                        .withState(RandomStringUtils.randomAlphabetic(10))
                        .withZip(RandomStringUtils.randomAlphanumeric(5))
                        .build(), "aa@aa.com"))
                .instanceExistingPatient();
    }

}
