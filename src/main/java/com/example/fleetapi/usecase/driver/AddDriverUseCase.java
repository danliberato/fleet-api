package com.example.fleetapi.usecase.driver;

import com.example.fleetapi.domain.rest.AddDriverRequest;
import com.example.fleetapi.domain.dto.driver.Driver;
import com.example.fleetapi.domain.exceptions.driver.DriverAlreadyExistsException;
import com.example.fleetapi.domain.exceptions.InvalidDateFormatException;
import com.example.fleetapi.infra.repository.driver.DriverRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.UUID;

@Component
public class AddDriverUseCase {

    private final DriverRepository driverRepository;

    public AddDriverUseCase(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public Driver addDriver(AddDriverRequest addDriverRequest) {
        if(driverRepository.findByActiveAndDeletedAndDocumentNumber(true, false, addDriverRequest.getDocumentNumber()) != null) {
            throw new DriverAlreadyExistsException("Driver with document number %s already exists".formatted(addDriverRequest.getDocumentNumber()));
        }

        validateDateFormat(addDriverRequest.getBirthDate());

        Driver driver = Driver.builder()
                .id(UUID.randomUUID().toString())
                .documentNumber(addDriverRequest.getDocumentNumber())
                .email(addDriverRequest.getEmail())
                .name(addDriverRequest.getName())
                .phoneNumber(addDriverRequest.getPhoneNumber())
                .birthDate(addDriverRequest.getBirthDate())
                .createdAt(OffsetDateTime.now(ZoneOffset.UTC).toString())
                .updatedAt(OffsetDateTime.now(ZoneOffset.UTC).toString())
                .active(true)
                .deleted(false)
                .build();
        return driverRepository.save(driver);

    }
    
    /**
     * Validates that the date string is in the format "yyyy-MM-dd"
     * @param dateStr The date string to validate
     * @throws InvalidDateFormatException if the date format is invalid
     */
    private void validateDateFormat(String dateStr) {
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
