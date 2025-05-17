package com.example.fleetapi.domain.exceptions;

import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.IllegalFormatException;

@Getter
public enum IssueEnum {
    DRIVER_NOT_FOUND(1, "Driver not found"),
    DRIVER_IN_ROUTE(2, "Driver is in route"),
    DRIVER_VEHICLE_IN_ROUTE(3, "Driver vehicle is in route")
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
