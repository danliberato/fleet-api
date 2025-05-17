package com.example.fleetapi.usecase.driver;

import com.example.fleetapi.domain.dto.driver.Driver;
import com.example.fleetapi.infra.repository.DriverRepository;
import org.springframework.stereotype.Component;

@Component
public class AddDriverUseCase {

    //no constraints
    private final DriverRepository driverRepository;

    public AddDriverUseCase(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public Driver addDriver(Driver driver) {
        driverRepository.findByDocumentNumber(driver.getDocumentNumber());
        driver.setActive(true);
        driver.setDeleted(false);
        return driverRepository.save(driver);
    }
}
