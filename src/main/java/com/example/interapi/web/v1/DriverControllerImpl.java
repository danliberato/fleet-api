package com.example.interapi.web.v1;

import com.example.interapi.domain.dto.driver.Driver;
import com.example.interapi.usecase.driver.AddDriverUseCase;
import com.example.interapi.usecase.driver.FindDriverUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DriverControllerImpl implements DriverControllerV1 {

    private final AddDriverUseCase addDriverUseCase;
    private final FindDriverUseCase findDriverUseCase;

    public DriverControllerImpl(AddDriverUseCase addDriverUseCase, FindDriverUseCase findDriverUseCase) {
        this.addDriverUseCase = addDriverUseCase;
        this.findDriverUseCase = findDriverUseCase;
    }


    @Override
    public ResponseEntity<List<Driver>> getAllDrivers(String countryCode, String requestId, String page, String pageSize) {
        return findDriverUseCase.findAllDrivers();
    }

    @Override
    public ResponseEntity<Driver> getDriver(String countryCode, String requestId, String id) {
        return null;
    }

    @Override
    public ResponseEntity<Driver> deleteDriver(String countryCode, String requestId, String id) {
        return null;
    }

    @Override
    public ResponseEntity<Driver> addDriver(String countryCode, String requestId, Driver driver) {
        addDriverUseCase.addDriver(driver);
        return null;
    }

    @Override
    public ResponseEntity<Driver> getDriverVehicles(String countryCode, String requestId, String driverId) {
        return null;
    }

    @Override
    public ResponseEntity<Driver> UpdateDriverVehicle(String countryCode, String requestId, String driverId, String vehicleId) {
        return null;
    }
}
