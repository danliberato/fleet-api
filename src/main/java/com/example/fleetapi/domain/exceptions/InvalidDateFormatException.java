package com.example.fleetapi.domain.exceptions;

public class InvalidDateFormatException extends DomainException {
    public InvalidDateFormatException(String message) {
        super(new Issue(IssueEnum.INVALID_DATE_FORMAT, message));
    }
}
