package com.example.fleetapi.web.v1;

import com.example.fleetapi.domain.rest.AddDriverRequest;
import com.example.fleetapi.domain.dto.driver.Driver;
import com.example.fleetapi.domain.exceptions.DriverAlreadyExistsException;
import com.example.fleetapi.domain.rest.DriverResponse;
import com.example.fleetapi.usecase.driver.AddDriverUseCase;
import com.example.fleetapi.usecase.driver.DeleteDriverUseCase;
import com.example.fleetapi.usecase.driver.FindDriverUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class DriverControllerImpl implements DriverControllerV1 {

    private final AddDriverUseCase addDriverUseCase;
    private final FindDriverUseCase findDriverUseCase;
    private final DeleteDriverUseCase deleteDriverUseCase;

    @Autowired
    public DriverControllerImpl(AddDriverUseCase addDriverUseCase, FindDriverUseCase findDriverUseCase, DeleteDriverUseCase deleteDriverUseCase) {
        this.addDriverUseCase = addDriverUseCase;
        this.findDriverUseCase = findDriverUseCase;
        this.deleteDriverUseCase = deleteDriverUseCase;
    }

    @Override
    public ResponseEntity<DriverResponse<List<Driver>>> getAllDrivers(String countryCode, String requestId, String page, String pageSize) {
        List<Driver> drivers = findDriverUseCase.findAllDrivers(page, pageSize).toList();
        return DriverResponse.successList(drivers);
    }

    @Override
    public ResponseEntity<DriverResponse<Driver>> getDriver(String countryCode, String requestId, String id) {
        Driver driver = findDriverUseCase.findActiveDriverById(id);
        return DriverResponse.success(driver);
    }

    @Override
    public ResponseEntity<DriverResponse<Driver>> deleteDriver(String countryCode, String requestId, String id) {
        log.info("deleteDriver: {}-{}-{}", countryCode, requestId, id);
        deleteDriverUseCase.deleteDriver(id);
        return DriverResponse.successEmpty();
    }

    @Override
    public ResponseEntity<DriverResponse<Driver>> addDriver(String countryCode, String requestId, AddDriverRequest addDriverRequest) {
        Driver driver = addDriverUseCase.addDriver(addDriverRequest);
        return DriverResponse.created(driver);
    }

    @Override
    public ResponseEntity<DriverResponse<Driver>> getDriverVehicles(String countryCode, String requestId, String driverId) {
        // Implementation needed
        return null;
    }

    @Override
    public ResponseEntity<DriverResponse<Driver>> UpdateDriverVehicle(String countryCode, String requestId, String driverId, String vehicleId) {
        // Implementation needed
        return null;
    }
}
