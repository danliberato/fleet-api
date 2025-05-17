package com.example.interapi.domain.dto.route;

/**
 * Enum representing the possible statuses of a route in the Fleet Hub application.
 */
public enum RouteStatus {
    /**
     * Route is planned but has not yet started
     */
    PLANNED,
    
    /**
     * Route is currently being executed
     */
    IN_PROGRESS,
    
    /**
     * Route has been completed successfully
     */
    COMPLETED,
    
    /**
     * Route has been cancelled
     */
    CANCELLED,
    
    /**
     * Route is delayed from its original schedule
     */
    DELAYED,
    
    /**
     * Route is on hold temporarily
     */
    ON_HOLD,
    
    /**
     * Route has been rescheduled to a different time
     */
    RESCHEDULED,
    
    /**
     * Route has been diverted from its original path
     */
    DIVERTED,
    
    /**
     * Route has encountered a problem
     */
    ISSUE_REPORTED
}
