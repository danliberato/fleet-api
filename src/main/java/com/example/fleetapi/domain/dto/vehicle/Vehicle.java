package com.example.fleetapi.domain.dto.vehicle;

import com.example.fleetapi.domain.dto.route.Route;
import com.example.fleetapi.domain.dto.driver.Driver;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;
import java.time.LocalDate;
import java.time.OffsetDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Vehicle {

    private String id;
    private String model;
    private String brand;
    private String registrationNumber;
    private String licensePlate;
    private String driverId;
    private VehicleStatus status;
    private boolean active;
    private boolean deleted;

    // Vehicle specifications
    private int year;
    private String color;

    // Dimensions and capacity
    private double weightKg;
    private int seatingCapacity;
    private double cargoCapacityKg;

    private VehicleType vehicleType; // e.g., truck, van, car, motorcycle

    // Performance and analytics
    private double totalDistanceTraveledKm;
    private int totalTripsCompleted;

    // Timestamps
    private OffsetDateTime createdAt;
    @LastModifiedDate
    private OffsetDateTime updatedAt;
}
