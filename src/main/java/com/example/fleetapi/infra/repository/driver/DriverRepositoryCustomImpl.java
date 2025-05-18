package com.example.fleetapi.infra.repository.driver;

import com.example.fleetapi.domain.dto.driver.Driver;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class DriverRepositoryCustomImpl implements DriverRepositoryCustom {

    MongoTemplate mongoTemplate;
    @Override
    public void deleteDriver(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        Update update = new Update().set("active", false);
        mongoTemplate.updateFirst(query, update, Driver.class);

    }
}
