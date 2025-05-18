package com.example.fleetapi.domain.exceptions.driver;

import com.example.fleetapi.domain.exceptions.DomainException;
import com.example.fleetapi.domain.exceptions.Issue;
import com.example.fleetapi.domain.exceptions.IssueEnum;

public class DriverNotFoundException extends DomainException {
    public DriverNotFoundException() {
        super(new Issue(IssueEnum.DRIVER_NOT_FOUND));
    }
}
