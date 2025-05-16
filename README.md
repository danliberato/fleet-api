# Inter API - Fleet Hub Application

This application provides a comprehensive API for managing a fleet of vehicles, drivers, and routes.

## Business Rules

### Vehicle Management

1. **Vehicle Status Lifecycle**:
   - Vehicles can be in various states: AVAILABLE, ASSIGNED, IN_USE, MAINTENANCE, REPAIR, OUT_OF_SERVICE, IDLE, FUELING, or RESERVED.
   - A vehicle must be AVAILABLE before it can be ASSIGNED to a route.
   - A vehicle in MAINTENANCE or REPAIR status cannot be assigned to routes.
   - Vehicles with expired registration or insurance (as per registrationExpiryDate and insuranceExpiryDate) should be marked as OUT_OF_SERVICE.

2. **Vehicle Specifications**:
   - All vehicles must have complete information regarding fuel type, capacity, and efficiency for proper route planning.
   - Vehicle dimensions (length, width, height) and capacity metrics (seating, cargo weight, cargo volume) must be recorded for load planning.
   - Each vehicle must be associated with a specific fleet and department for organizational purposes.

3. **Vehicle Tracking**:
   - Real-time tracking data (currentLatitude, currentLongitude, currentSpeedKmh) must be updated at regular intervals when a vehicle is IN_USE.
   - Maintenance scheduling is mandatory, with lastMaintenanceDate and nextMaintenanceDate being used to trigger maintenance alerts.
   - Performance metrics (totalDistanceTraveledKm, totalTripsCompleted, averageSpeedKmh) are automatically calculated based on completed routes.

### Route Management

1. **Route Status Progression**:
   - Routes follow a standard lifecycle: PLANNED → IN_PROGRESS → COMPLETED (or alternative terminal states).
   - Additional statuses include: CANCELLED, DELAYED, ON_HOLD, RESCHEDULED, DIVERTED, and ISSUE_REPORTED.
   - A route can only be marked as IN_PROGRESS when it has both a vehicle and driver assigned.
   - A route can only be marked as COMPLETED when the vehicle has reached the destination address.

2. **Route Planning Requirements**:
   - All routes must have origin and destination coordinates (latitude/longitude) as well as human-readable addresses.
   - Routes must have scheduledDepartureTime and scheduledArrivalTime for planning purposes.
   - Distance (distanceInKilometers) and duration (estimatedDurationMinutes) must be calculated during route planning.
   - Waypoints can be added to routes to indicate stops or checkpoints along the journey.

3. **Route Monitoring and Analytics**:
   - Actual times (actualDepartureTime, actualArrivalTime) and duration (actualDurationMinutes) are recorded for performance analysis.
   - Environmental impact metrics (fuelConsumptionEstimate, co2EmissionsEstimate) must be calculated for all routes.
   - Route status changes must be logged with timestamps for auditing and performance analysis.

### Driver and Vehicle Relationships

1. **Assignment Rules**:
   - A driver can be assigned to only one vehicle at a time.
   - A vehicle can be assigned to only one driver at a time.
   - A route must have both a vehicle and driver assigned before it can be started.
   - When a vehicle is assigned to a route, its status must be updated to ASSIGNED.

2. **Operational Constraints**:
   - Drivers must have appropriate licenses for the vehicle types they are assigned to.
   - Vehicles must have sufficient fuel levels (currentFuelLevelLiters) for the planned route distance.
   - Routes should be assigned to vehicles with appropriate cargo and seating capacity for the mission requirements.

## API Usage

[Documentation for API endpoints will be added here]

## Installation and Setup

[Installation instructions will be added here]
