package com.example.fleetapi.domain.exceptions.vehicle;

import com.example.fleetapi.domain.exceptions.DomainException;
import com.example.fleetapi.domain.exceptions.Issue;
import com.example.fleetapi.domain.exceptions.IssueEnum;

public class VehicleAlreadyExistsException extends DomainException {
    public VehicleAlreadyExistsException(String message) {
        super(new Issue(IssueEnum.VEHICLE_ALREADY_EXISTS, message));
    }
}
