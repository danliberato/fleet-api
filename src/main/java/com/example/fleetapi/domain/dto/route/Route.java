package com.example.fleetapi.domain.dto.route;

import com.example.fleetapi.domain.dto.driver.Driver;
import com.example.fleetapi.domain.dto.vehicle.Vehicle;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Route {

    // Basic information
    private String id;
    private String name;
    private String description;

    // Location information
    private String originAddress;
    private String destinationAddress;

    // Timing information
    private LocalDateTime departureTime;
    private LocalDateTime finishTime;

    // Route details
    private List<RouteEvent> events;

    // Associated entities
    private Vehicle vehicle;
    private String driverId;

    private RouteStatus lastStatus;
}

