package com.seef.diag.patient;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {"com.seef.diag.patient"})
@ComponentScan(basePackages = {
        "com.seef.diag.patient"
})
public class MongoPersistenceTestConfig {
}
