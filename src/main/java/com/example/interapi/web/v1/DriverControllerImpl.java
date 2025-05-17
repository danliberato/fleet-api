package com.example.interapi.web.v1;

import com.example.interapi.domain.dto.driver.Driver;
import com.example.interapi.usecase.driver.AddDriverUseCase;
import com.example.interapi.usecase.driver.DeleteDriverUseCase;
import com.example.interapi.usecase.driver.FindDriverUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class DriverControllerImpl implements DriverControllerV1 {

    private final AddDriverUseCase addDriverUseCase;
    private final FindDriverUseCase findDriverUseCase;
    private final DeleteDriverUseCase deleteDriverUseCase;

    public DriverControllerImpl(AddDriverUseCase addDriverUseCase, FindDriverUseCase findDriverUseCase, DeleteDriverUseCase deleteDriverUseCase) {
        this.addDriverUseCase = addDriverUseCase;
        this.findDriverUseCase = findDriverUseCase;
        this.deleteDriverUseCase = deleteDriverUseCase;
    }


    @Override
    public ResponseEntity<List<Driver>> getAllDrivers(String countryCode, String requestId, String page, String pageSize) {
        log.info("getAllDrivers: {}-{}-{}-{}".formatted(countryCode, requestId, page, pageSize));
        return ResponseEntity.status(200).body(findDriverUseCase.findAllDrivers(page, pageSize).toList());
    }

    @Override
    public ResponseEntity<Driver> getDriver(String countryCode, String requestId, String id) {

        Driver driver = findDriverUseCase.findDriverById(id);
        return ResponseEntity.status(200).body(driver);
    }

    @Override
    public ResponseEntity<Void> deleteDriver(String countryCode, String requestId, String id) {
        log.info("deleteDriver: {}-{}-{}".formatted(countryCode, requestId, id));
        deleteDriverUseCase.deleteDriver(id);
        return ResponseEntity.status(200).build();
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
