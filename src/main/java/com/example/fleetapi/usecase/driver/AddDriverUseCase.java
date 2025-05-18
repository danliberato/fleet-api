package com.example.fleetapi.usecase.driver;

import com.example.fleetapi.domain.rest.AddDriverRequest;
import com.example.fleetapi.domain.dto.driver.Driver;
import com.example.fleetapi.domain.exceptions.DriverAlreadyExistsException;
import com.example.fleetapi.infra.repository.driver.DriverRepository;
import org.springframework.stereotype.Component;

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
        Driver driver = Driver.builder()
                .id(UUID.randomUUID().toString())
                .documentNumber(addDriverRequest.getDocumentNumber())
                .email(addDriverRequest.getEmail())
                .name(addDriverRequest.getName())
                .phoneNumber(addDriverRequest.getPhoneNumber())
                .birthDate(addDriverRequest.getBirthDate())
                .active(true)
                .deleted(false)
                        .build();
        return driverRepository.save(driver);

    }
}
