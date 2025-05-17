package com.example.interapi.usecase.driver;

import com.example.interapi.domain.dto.driver.Driver;
import com.example.interapi.domain.exceptions.DriverNotFoundException;
import com.example.interapi.infra.repository.DriverRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class DeleteDriverUseCase {


    private final DriverRepository driverRepository;

    public DeleteDriverUseCase(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public void deleteDriver(String id) {
        Driver driver = driverRepository.findDriverByActiveAndId(true, UUID.fromString(id));
        validateDriver(driver);
        driver.setDeleted(true);
        driverRepository.updateDriver(driver);
    }

    private static void validateDriver(Driver driver) {
        if (driver == null) {
            throw (new DriverNotFoundException());
        }
        //ToDo: check if driver is assigned to any route
        //ToDo: check if driver's vehicles are assigned to any route
        //ToDo: check if driver's vehicles are in status = IN_USE
    }

}
