package com.seef.adapter.repository.mongo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {"com.seef.diag.adapter.repository.mongo"})
@ComponentScan(basePackages = {
        "com.seef.diag.adapter.repository.mongo"
})
public class MongoPersistenceTestConfig {
}
