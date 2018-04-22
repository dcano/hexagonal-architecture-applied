package com.seef.adapter.repository.jpa.patient;

import com.seef.adapter.repository.jpa.config.JpaPersistenceTestConfig;
import com.seef.diag.adapter.repository.PatientRepositoryTest;
import com.seef.diag.domain.port.PatientRepository;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {JpaPersistenceTestConfig.class})
@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class PatientJpaRepositoryTest extends PatientRepositoryTest {

    @Autowired
    private PatientRepository patientRepository;

    @Before
    public void setup() {
        super.setPatientRepository(patientRepository);
    }

}
