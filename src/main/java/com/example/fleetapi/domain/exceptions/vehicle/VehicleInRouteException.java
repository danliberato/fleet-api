package com.example.fleetapi.domain.exceptions.vehicle;

import com.example.fleetapi.domain.exceptions.DomainException;
import com.example.fleetapi.domain.exceptions.Issue;
import com.example.fleetapi.domain.exceptions.IssueEnum;

public class VehicleInRouteException extends DomainException {

    public VehicleInRouteException() {
        super(new Issue(IssueEnum.VEHICLE_IN_ROUTE));
    }


}
