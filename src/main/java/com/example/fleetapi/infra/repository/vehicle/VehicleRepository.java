package com.example.fleetapi.infra.repository.vehicle;

import com.example.fleetapi.domain.dto.vehicle.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends MongoRepository<Vehicle, String>, VehicleRepositoryCustom {

    Vehicle findDriverByActiveAndDeletedAndId(boolean active, boolean deleted, String id);

    List<Vehicle> findByDriverId(String driverId);
}
