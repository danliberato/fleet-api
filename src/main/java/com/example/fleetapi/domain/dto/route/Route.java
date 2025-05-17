package com.example.interapi.domain.dto.route;

import com.example.interapi.domain.dto.driver.Driver;
import com.example.interapi.domain.dto.vehicle.Vehicle;

import java.time.LocalDateTime;
import java.util.List;

public class Route {

    // Basic information
    private String id;
    private String name;
    private String description;

    // Location information
    private String originAddress;
    private double originLatitude;
    private double originLongitude;
    private String destinationAddress;
    private double destinationLatitude;
    private double destinationLongitude;
    private List<String> waypointIds;  // For stops along the route

    // Timing information
    private LocalDateTime scheduledDepartureTime;
    private LocalDateTime scheduledArrivalTime;
    private LocalDateTime actualDepartureTime;
    private LocalDateTime actualArrivalTime;

    // Distance and duration
    private double distanceInKilometers;
    private int estimatedDurationMinutes;
    private int actualDurationMinutes;

    // Associated entities
    private Vehicle vehicle;
    private Driver driver;

    // Status tracking
    private RouteStatus status;

    // Additional fleet management fields
    private double fuelConsumptionEstimate;
    private double co2EmissionsEstimate;

}

