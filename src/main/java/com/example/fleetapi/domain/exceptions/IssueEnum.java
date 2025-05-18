package com.example.fleetapi.domain.exceptions;

import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.IllegalFormatException;

@Getter
public enum IssueEnum {
    DRIVER_NOT_FOUND(1, "Driver not found"),
    DRIVER_IN_ROUTE(2, "Driver is in route"),
    DRIVER_VEHICLE_IN_ROUTE(3, "Driver vehicle is in route"),
    DRIVER_ALREADY_EXISTS(4, "Driver already exists"),
    VEHICLE_NOT_FOUND(5, "Vehicle not found"),
    VEHICLE_IN_ROUTE(6, "Vehicle is in route"),
    VEHICLE_ALREADY_EXISTS(7, "Vehicle already exists"),
    INVALID_DATE_FORMAT(8, "Invalid date format. Format must be yyyy-MM-dd")
    ;

    private final Logger logger = LogManager.getLogger(IssueEnum.class);

    private final int code;

    private final String message;

    IssueEnum(final int code, final String message) {
        this.code = code;
        this.message = message;
    }

    public String getFormattedMessage(final Object... args) {

        if (message == null) {
            return "";
        }

        try {
            return String.format(message, args);
        } catch (final IllegalFormatException e) {
            logger.warn(e.getMessage(), e);
            return message.replace("%s", "");
        }
    }
}
