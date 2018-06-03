package com.seef.diag.patient;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = {
        "com.seef.diag.patient"
})
@EntityScan(basePackages = {
        "com.seef.diag.patient"
})
@EnableJpaRepositories(basePackages = {
        "com.seef.diag.patient"
})
public class JpaPersistenceTestConfig {
}
