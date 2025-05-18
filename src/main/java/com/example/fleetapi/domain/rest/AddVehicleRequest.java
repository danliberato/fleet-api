package com.example.fleetapi.domain.rest;

import com.example.fleetapi.domain.dto.driver.Driver;
import com.example.fleetapi.domain.dto.vehicle.VehicleType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddVehicleRequest {

    private String model;
    private String brand;
    private String registrationNumber;
    private String licensePlate;
    private Driver driver;
    private boolean isActive;
    private boolean isDeleted;

    // Vehicle specifications
    private int year;
    private String color;

    // Dimensions and capacity
    private double weightKg;
    private int seatingCapacity;
    private double cargoCapacityKg;

    private VehicleType vehicleType; // e.g., truck, van, car, motorcycle
}
