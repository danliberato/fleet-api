package com.example.fleetapi.domain.exceptions.driver;

import com.example.fleetapi.domain.exceptions.DomainException;
import com.example.fleetapi.domain.exceptions.Issue;
import com.example.fleetapi.domain.exceptions.IssueEnum;

public class DriverInRouteException extends DomainException {

    public DriverInRouteException() {
        super(new Issue(IssueEnum.DRIVER_IN_ROUTE));
    }


}
