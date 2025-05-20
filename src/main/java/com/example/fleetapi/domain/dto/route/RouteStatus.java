package com.example.fleetapi.domain.dto.route;

/**
 * Enum representing the possible statuses of a route in the Fleet Hub application.
 */
public enum RouteStatus {

    /**
     * Route has not yet been initiated
     */
    PLANNED,

    /**
     * Route has been initiated
     */
    STARTED,

    
    /**
     * Route has been completed successfully
     */
    COMPLETED,
    
    /**
     * Route has been cancelled
     */
    CANCELLED,

    /**
     * Route has been rejected by the receiver
     */
    REJECTED,
    
    /**
     * Route has encountered a problem
     */
    ISSUE_REPORTED
}
