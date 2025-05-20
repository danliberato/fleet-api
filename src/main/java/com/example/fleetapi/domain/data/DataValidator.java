package com.example.fleetapi.domain.data;

import com.example.fleetapi.domain.exceptions.InvalidDateFormatException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DataValidator {

    /**
     * Validates that the date string is in the format "yyyy-MM-dd"
     * @param dateStr The date string to validate
     * @throws InvalidDateFormatException if the date format is invalid
     */
    public static void validateDateFormat(String dateStr) {
        if (dateStr == null || dateStr.isEmpty()) {
            throw new InvalidDateFormatException("Birth date cannot be empty");
        }

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate.parse(dateStr, formatter);
        } catch (DateTimeParseException e) {
            throw new InvalidDateFormatException("Invalid date format. Date must be in format yyyy-MM-dd");
        }
    }
}
