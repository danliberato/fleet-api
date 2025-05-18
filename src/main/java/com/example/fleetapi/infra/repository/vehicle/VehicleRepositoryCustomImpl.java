package com.example.fleetapi.infra.repository.vehicle;

import com.example.fleetapi.domain.dto.vehicle.Vehicle;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class VehicleRepositoryCustomImpl implements VehicleRepositoryCustom {

    MongoTemplate mongoTemplate;
    @Override
    public void deleteVehicle(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        Update update = new Update().set("active", false).set("deleted", true);
        mongoTemplate.updateFirst(query, update, Vehicle.class);

    }
}
