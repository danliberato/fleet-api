package com.example.fleetapi.domain.rest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateRouteRequest {

    // Basic information
    private String name;
    private String description;

    // Location information
    private String originAddress;
    private String destinationAddress;


    // Associated entities
    private String vehicleId;
    private String driverId;

}
