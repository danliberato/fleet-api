package com.example.fleetapi.domain.exceptions;

public class DriverInRouteException extends DomainException {

    public DriverInRouteException() {
        super(new Issue(IssueEnum.DRIVER_IN_ROUTE));
    }


}
