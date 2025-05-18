package com.example.fleetapi.domain.dto.vehicle;

import com.example.fleetapi.domain.dto.route.Route;
import com.example.fleetapi.domain.dto.driver.Driver;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class Vehicle {

    private String id;
    private String model;
    private String brand;
    private String registrationNumber;
    private String licensePlate;
    private Driver driver;
    private Route route;
    private VehicleStatus status;
    private boolean isActive;
    private boolean isDeleted;
    
    // Vehicle specifications
    private int year;
    private String color;
    
    // Dimensions and capacity
    private double weightKg;
    private double lengthMeters;
    private double widthMeters;
    private double heightMeters;
    private int seatingCapacity;
    private double cargoCapacityKg;
    private double cargoVolumeM3;
    
    // Tracking and telemetry
    private double odometerReadingKm;
    private LocalDate lastMaintenanceDate;
    private LocalDate nextMaintenanceDate;

    private VehicleType vehicleType; // e.g., truck, van, car, motorcycle
    
    // Compliance and documentation
    private LocalDate registrationExpiryDate;
    private LocalDate insuranceExpiryDate;
    
    // Performance and analytics
    private double totalDistanceTraveledKm;
    private int totalTripsCompleted;
    private double maintenanceCostToDate;
}
