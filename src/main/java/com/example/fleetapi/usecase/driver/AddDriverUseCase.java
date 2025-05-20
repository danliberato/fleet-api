package com.example.fleetapi.usecase.driver;

import com.example.fleetapi.domain.dto.driver.Driver;
import com.example.fleetapi.domain.exceptions.driver.DriverAlreadyExistsException;
import com.example.fleetapi.domain.rest.AddDriverRequest;
import com.example.fleetapi.infra.repository.driver.DriverRepository;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

import static com.example.fleetapi.domain.data.DataValidator.validateDateFormat;

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
}
