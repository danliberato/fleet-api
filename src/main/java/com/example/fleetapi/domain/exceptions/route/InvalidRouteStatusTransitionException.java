package com.example.fleetapi.domain.exceptions.route;

import com.example.fleetapi.domain.dto.route.RouteStatus;
import com.example.fleetapi.domain.exceptions.IssueEnum;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidRouteStatusTransitionException extends RuntimeException {
    
    public InvalidRouteStatusTransitionException(RouteStatus currentStatus, RouteStatus newStatus) {
        super(IssueEnum.INVALID_ROUTE_STATUS_TRANSITION.getFormattedMessage(currentStatus, newStatus));
    }
}
