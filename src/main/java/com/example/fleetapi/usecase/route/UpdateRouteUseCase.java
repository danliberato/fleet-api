package com.example.fleetapi.usecase.route;

import com.example.fleetapi.domain.dto.route.Route;
import com.example.fleetapi.domain.dto.route.RouteEvent;
import com.example.fleetapi.domain.dto.route.RouteStatus;
import com.example.fleetapi.domain.exceptions.route.InvalidRouteStatusTransitionException;
import com.example.fleetapi.domain.exceptions.route.RouteNotFoundException;
import com.example.fleetapi.infra.repository.route.RouteRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UpdateRouteUseCase {

    private final RouteRepository routeRepository;

    public UpdateRouteUseCase(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    /**
     *      Driver can start multiple routes
     *      Input:
     *          routeId
     *          timestamp
     *          status
     *
     *      State machines V1:
     *          1. STARTED -> CANCELLED, COMPLETED
     *
     *      State machines V2:
     *          1. PLANNED -> STARTED, CANCELLED
     *          2. STARTED -> COMPLETED, REJECTED, CANCELLED (final statuses)
     *
     *      Output:
     *          Add this event to RouteEvent list
     *          update the Route.lastStatus with request.status
     *          if final status:
     *              - Populate Route.finishTime (then persist)
     *              - Send RouteEvent to PayoutUseCase (
     */

    public void updateRoute(String routeId, LocalDateTime timestamp, RouteStatus newStatus) {
        Route route = routeRepository.findById(routeId).orElseThrow(() -> new RouteNotFoundException(routeId));

        this.validateStatusChange(route.getLastStatus(), newStatus);

        route.setLastStatus(newStatus);
        route.getEvents().add(new RouteEvent(timestamp, newStatus).build());

        routeRepository.save(route);

        if (newStatus == RouteStatus.COMPLETED || newStatus == RouteStatus.REJECTED || newStatus == RouteStatus.CANCELLED) {
            route.setFinishTime(timestamp);
            //
        }

    }

    private void validateStatusChange(RouteStatus currentStatus, RouteStatus newStatus) {
        // State Machine v1 validation
        // Only allows: STARTED -> CANCELLED, COMPLETED
        boolean isValidTransition = currentStatus == RouteStatus.STARTED && 
                                   (newStatus == RouteStatus.CANCELLED || 
                                    newStatus == RouteStatus.COMPLETED);
        
        if (!isValidTransition) {
            throw new InvalidRouteStatusTransitionException(currentStatus, newStatus);
        }
    }
}
