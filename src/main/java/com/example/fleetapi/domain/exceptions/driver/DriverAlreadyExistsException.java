package com.example.fleetapi.domain.exceptions.driver;

import com.example.fleetapi.domain.exceptions.DomainException;
import com.example.fleetapi.domain.exceptions.Issue;
import com.example.fleetapi.domain.exceptions.IssueEnum;

public class DriverAlreadyExistsException extends DomainException {
    public DriverAlreadyExistsException(String message) {
        super(new Issue(IssueEnum.DRIVER_ALREADY_EXISTS, message));
    }
}
