package com.example.fleetapi.usecase.driver;

import com.example.fleetapi.domain.dto.driver.Driver;
import com.example.fleetapi.domain.exceptions.DriverNotFoundException;
import com.example.fleetapi.infra.repository.DriverRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DeleteDriverUseCase {


    private final DriverRepository driverRepository;

    public DeleteDriverUseCase(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public void deleteDriver(String id) {
        UUID driverId = UUID.fromString(id);
        Driver driver = driverRepository.findDriverByActiveAndId(true, driverId);
        validateDriver(driver);
        driverRepository.deleteDriver(driverId);
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
