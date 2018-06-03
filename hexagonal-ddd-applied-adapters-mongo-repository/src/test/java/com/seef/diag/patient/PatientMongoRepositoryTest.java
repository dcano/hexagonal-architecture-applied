package com.seef.diag.patient;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MongoPersistenceTestConfig.class})
@DataMongoTest
public class PatientMongoRepositoryTest extends PatientRepositoryTest {

    @Autowired
    private PatientRepository patientRepository;

    @Before
    public void setup() {
        super.setPatientRepository(patientRepository);
    }


}
