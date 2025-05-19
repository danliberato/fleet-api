package com.example.fleetapi.web.v1;

import com.example.fleetapi.domain.rest.AddDriverRequest;
import com.example.fleetapi.domain.dto.driver.Driver;
import com.example.fleetapi.domain.rest.DriverResponse;
import com.example.fleetapi.infra.ApiRestConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = ApiRestConstants.API_VERSION, produces = "application/json", consumes = "application/json")
public interface DriverControllerV1 {

    @GetMapping(ApiRestConstants.DRIVERS)
    ResponseEntity<DriverResponse<List<Driver>>> getAllDrivers(
            @RequestHeader(value = ApiRestConstants.COUNTRY_CODE_HEADER) final String countryCode,
            @RequestHeader(value = ApiRestConstants.REQUEST_ID_HEADER) final String requestId,
            @RequestParam(value = "page", required = false, defaultValue = "0") final String page,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") final String pageSize
    );

    @GetMapping(ApiRestConstants.DRIVERS_ID)
    ResponseEntity<DriverResponse<Driver>> getDriver(
            @RequestHeader(value = ApiRestConstants.COUNTRY_CODE_HEADER) final String countryCode,
            @RequestHeader(value = ApiRestConstants.REQUEST_ID_HEADER) final String requestId,
            @PathVariable String id);

    @DeleteMapping(ApiRestConstants.DRIVERS_ID)
    ResponseEntity<DriverResponse<Driver>> deleteDriver(
            @RequestHeader(value = ApiRestConstants.COUNTRY_CODE_HEADER) final String countryCode,
            @RequestHeader(value = ApiRestConstants.REQUEST_ID_HEADER) final String requestId,
            @PathVariable String id);

    @PostMapping(ApiRestConstants.DRIVERS)
    ResponseEntity<DriverResponse<Driver>> addDriver(
            @RequestHeader(value = ApiRestConstants.COUNTRY_CODE_HEADER) final String countryCode,
            @RequestHeader(value = ApiRestConstants.REQUEST_ID_HEADER) final String requestId,
            @RequestBody AddDriverRequest driverRequest);

    @GetMapping(ApiRestConstants.DRIVERS_ID_VEHICLES)
    ResponseEntity<DriverResponse<Driver>> getDriverVehicles(
            @RequestHeader(value = ApiRestConstants.COUNTRY_CODE_HEADER) final String countryCode,
            @RequestHeader(value = ApiRestConstants.REQUEST_ID_HEADER) final String requestId,
            @PathVariable String driverId);

}
