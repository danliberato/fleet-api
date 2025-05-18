package com.example.fleetapi.domain.exceptions;

public class DriverAlreadyExistsException extends DomainException {
    public DriverAlreadyExistsException(String message) {
        super(new Issue(IssueEnum.DRIVER_ALREADY_EXISTS, message));
    }
}
