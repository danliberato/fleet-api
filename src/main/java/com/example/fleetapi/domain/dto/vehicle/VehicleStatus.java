package com.example.fleetapi.domain.dto.vehicle;

/**
 * Enum representing the possible statuses of a vehicle in the Fleet Hub application.
 */
public enum VehicleStatus {
    /**
     * Vehicle is available for assignment
     */
    AVAILABLE,
    
    /**
     * Vehicle is currently assigned to a route
     */
    ASSIGNED,
    
    /**
     * Vehicle is currently in use on a route
     */
    IN_USE,
    
    /**
     * Vehicle is undergoing maintenance
     */
    MAINTENANCE,
    
    /**
     * Vehicle is out of service due to repairs
     */
    REPAIR,
    
    /**
     * Vehicle is out of service
     */
    OUT_OF_SERVICE,
    
    /**
     * Vehicle is idle but assigned
     */
    IDLE,
    
    /**
     * Vehicle is fueling
     */
    FUELING,
    
    /**
     * Vehicle is reserved for future use
     */
    RESERVED
}
