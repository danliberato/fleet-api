package com.example.interapi.infra.config.database;

import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
@Import(MongoAutoConfiguration.class)
public class MongoDBConfiguration {

    @Bean
    public CustomMongoHealthIndicator customMongoHealthIndicator(final MongoTemplate mongoTemplate) {
        return new CustomMongoHealthIndicator(mongoTemplate);
    }
}
