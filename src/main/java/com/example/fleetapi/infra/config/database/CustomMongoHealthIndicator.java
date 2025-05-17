package com.example.interapi.infra.config.database;

import org.bson.Document;
import org.springframework.boot.actuate.data.mongo.MongoHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.data.mongodb.core.MongoTemplate;

public class CustomMongoHealthIndicator extends MongoHealthIndicator {

    private final MongoTemplate mongoTemplate;

    public CustomMongoHealthIndicator(final MongoTemplate mongoTemplate) {
        super(mongoTemplate);

        this.mongoTemplate = mongoTemplate;
    }

    @Override
    protected void doHealthCheck(final Health.Builder builder) {
        final Document result = mongoTemplate.executeCommand("{ isMaster: 1 }");
        builder.up().withDetail("maxWireVersion", result.getInteger("maxWireVersion"));
    }
}