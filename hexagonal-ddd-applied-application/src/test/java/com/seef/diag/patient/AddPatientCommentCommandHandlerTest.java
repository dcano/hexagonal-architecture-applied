package com.seef.diag.patient;

import com.seef.diag.commons.DomainCommand;
import com.seef.diag.commons.TenantId;
import org.apache.commons.lang3.RandomStringUtils;
import org.assertj.core.api.WithAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.UUID;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AddPatientCommentCommandHandlerTest implements WithAssertions {

    @InjectMocks
    private AddPatientCommentCommandHandler commandHandler;

    @Mock
    private PatientRepository patientRepository;

    @Mock
    private PatientOutputPort patientOutputPort;

    @Captor
    private ArgumentCaptor<Patient> patientCaptor;

    @Captor
    private ArgumentCaptor<AddPatientCommentCommand> commandCaptor;

    @Test
    public void given_a_patient_and_a_comment_the_comment_is_added() {

        //given a patient
        String tenantId = UUID.randomUUID().toString();
        Patient expectedPatient = PatientTestStub.randomPatientForTenant(tenantId);
        int expectedNumberOfComments = (expectedPatient.getComments()!=null?expectedPatient.getComments().size():0) + 1;
        given(patientRepository.findOneBy(any(PatientId.class), any(TenantId.class))).willReturn(expectedPatient);

        //And a command
        AddPatientCommentCommand command = new AddPatientCommentCommand(expectedPatient.getPatientId().value(), RandomStringUtils.randomAlphabetic(50), CommentCriticality.LOW, tenantId);
        commandHandler.handle(command);
        //the comment is added to the comment list of the patient
        verify(patientOutputPort).write(patientCaptor.capture(), commandCaptor.capture());
        Patient actualPatient = patientCaptor.getValue();
        DomainCommand actualCommand = commandCaptor.getValue();
        assertThat(actualCommand.commandUid()).as("Expected command").isEqualTo(command.commandUid());
        assertThat(actualPatient.getPatientId().value()).as("Expected patient id").isEqualTo(expectedPatient.getPatientId().value());
        assertThat(actualPatient.getComments().size()).as("Comment list is increased by one").isEqualTo(expectedNumberOfComments);
        assertThat(actualPatient.getComments().get(expectedNumberOfComments-1).getComment()).as("Comment is the expected").isEqualTo(command.getComment());
    }

    @Test
    public void given_a_non_existent_patient_exception_is_thrown () {
        //given a non-existent patient
        String tenantId = UUID.randomUUID().toString();
        given(patientRepository.findOneBy(any(PatientId.class), any(TenantId.class))).willReturn(null);

        //And a command
        AddPatientCommentCommand command = new AddPatientCommentCommand(UUID.randomUUID().toString(), RandomStringUtils.randomAlphabetic(50), CommentCriticality.LOW, tenantId);

        final Throwable throwable = catchThrowable(() -> commandHandler.handle(command));

        // Then
        assertThat(throwable)
                .as("Command handler can not process AddPatientCommentCommand")
                .isInstanceOf(IllegalStateException.class);


    }


}
