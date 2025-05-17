package com.example.fleetapi.web.v1;

import com.example.fleetapi.domain.dto.driver.AddDriverRequest;
import com.example.fleetapi.domain.dto.driver.Driver;
import com.example.fleetapi.infra.ApiRestConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = ApiRestConstants.API_VERSION, produces = "application/json", consumes = "application/json")
public interface DriverControllerV1 {


    @GetMapping(ApiRestConstants.DRIVERS)
    ResponseEntity<List<Driver>> getAllDrivers(
            @RequestHeader(value = ApiRestConstants.COUNTRY_CODE_HEADER) final String countryCode,
            @RequestHeader(value = ApiRestConstants.REQUEST_ID_HEADER) final String requestId,
            @RequestParam(value = "page", required = false, defaultValue = "0") final String page,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") final String pageSize
    );

    @GetMapping(ApiRestConstants.DRIVERS_ID)
    ResponseEntity<Driver> getDriver(
            @RequestHeader(value = ApiRestConstants.COUNTRY_CODE_HEADER) final String countryCode,
            @RequestHeader(value = ApiRestConstants.REQUEST_ID_HEADER) final String requestId,
            @PathVariable String id);

    @DeleteMapping(ApiRestConstants.DRIVERS_ID)
    ResponseEntity<Void> deleteDriver(
            @RequestHeader(value = ApiRestConstants.COUNTRY_CODE_HEADER) final String countryCode,
            @RequestHeader(value = ApiRestConstants.REQUEST_ID_HEADER) final String requestId,
            @PathVariable String id);

    @PostMapping(ApiRestConstants.DRIVERS)
    ResponseEntity<Driver> addDriver(
            @RequestHeader(value = ApiRestConstants.COUNTRY_CODE_HEADER) final String countryCode,
            @RequestHeader(value = ApiRestConstants.REQUEST_ID_HEADER) final String requestId,
            @RequestBody AddDriverRequest driverRequest);

    @GetMapping(ApiRestConstants.DRIVERS_ID_VEHICLES)
    ResponseEntity<Driver> getDriverVehicles(
            @RequestHeader(value = ApiRestConstants.COUNTRY_CODE_HEADER) final String countryCode,
            @RequestHeader(value = ApiRestConstants.REQUEST_ID_HEADER) final String requestId,
            @PathVariable String driverId);

    @PatchMapping(ApiRestConstants.DRIVERS_ID_VEHICLES_ID)
    ResponseEntity<Driver> UpdateDriverVehicle(
            @RequestHeader(value = ApiRestConstants.COUNTRY_CODE_HEADER) final String countryCode,
            @RequestHeader(value = ApiRestConstants.REQUEST_ID_HEADER) final String requestId,
            @PathVariable String driverId, @PathVariable String vehicleId);


}
