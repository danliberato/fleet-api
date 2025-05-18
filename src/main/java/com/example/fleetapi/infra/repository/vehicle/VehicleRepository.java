package com.example.fleetapi.infra.repository.vehicle;

import com.example.fleetapi.domain.dto.driver.Driver;
import com.example.fleetapi.domain.dto.vehicle.Vehicle;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends MongoRepository<Vehicle, String>, VehicleRepositoryCustom {

    Vehicle findByLicensePlate(String licensePlate);

    Vehicle findByRegistrationNumber(String registrationNumber);

    @NotNull
    Page<Vehicle> findVehicleByDriver(@NotNull Driver driver, @NotNull Pageable pageable);

    Vehicle findVehicleById(String id);

    List<Vehicle> findByDriver(Driver driver);
}
