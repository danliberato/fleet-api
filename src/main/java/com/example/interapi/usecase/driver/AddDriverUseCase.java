package com.example.interapi.usecase.driver;

import com.example.interapi.domain.dto.driver.Driver;
import com.example.interapi.infra.repository.DriverRepository;
import org.springframework.stereotype.Component;

@Component
public class AddDriverUseCase {

    //no constraints
    private DriverRepository driverRepository;

    public AddDriverUseCase(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    private Driver addDriver(Driver driver) {
        driverRepository.findByDocumentNumber(driver.getDocumentNumber());
        driverRepository.save(driver);
    }
}
