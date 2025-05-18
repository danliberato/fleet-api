package com.example.fleetapi.domain.exceptions.vehicle;

import com.example.fleetapi.domain.exceptions.DomainException;
import com.example.fleetapi.domain.exceptions.Issue;
import com.example.fleetapi.domain.exceptions.IssueEnum;

public class VehicleNotFoundException extends DomainException {
    public VehicleNotFoundException() {
        super(new Issue(IssueEnum.VEHICLE_NOT_FOUND));
    }
}
