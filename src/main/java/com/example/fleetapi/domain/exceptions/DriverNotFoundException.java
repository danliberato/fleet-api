package com.example.fleetapi.domain.exceptions;

public class DriverNotFoundException extends DomainException {
    public DriverNotFoundException() {
        super(new Issue(IssueEnum.DRIVER_NOT_FOUND));
    }
}
