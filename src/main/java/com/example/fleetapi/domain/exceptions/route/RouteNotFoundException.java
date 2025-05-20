package com.example.fleetapi.domain.exceptions.route;

import com.example.fleetapi.domain.exceptions.DomainException;
import com.example.fleetapi.domain.exceptions.Issue;
import com.example.fleetapi.domain.exceptions.IssueEnum;

public class RouteNotFoundException extends DomainException {
    public RouteNotFoundException(String message) {
        super(new Issue(IssueEnum.ROUTE_NOT_FOUND, message));
    }
}
