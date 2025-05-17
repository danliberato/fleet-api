package com.example.fleetapi.domain.exceptions;

public class DriverAssignedToRouteException extends DomainException {

    public DriverAssignedToRouteException() {
        super(new Issue(IssueEnum.DRIVER_IN_ROUTE));
    }


}
