package com.example.interapi.web.v1;

import com.example.interapi.domain.dto.vehicle.Vehicle;
import com.example.interapi.infra.ApiRestConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = ApiRestConstants.API_VERSION, produces = "application/json", consumes = "application/json")
public interface VehicleControllerV1 {

    @GetMapping(ApiRestConstants.VEHICLES)
    ResponseEntity<List<Vehicle>> getAllVehicles(
            @RequestHeader(value = ApiRestConstants.COUNTRY_CODE_HEADER) final String countryCode,
            @RequestHeader(value = ApiRestConstants.REQUEST_ID_HEADER) final String requestId,
            @RequestParam(value = "page", required = false, defaultValue = "0") final String page,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") final String pageSize
    );

    @PostMapping(ApiRestConstants.VEHICLES)
    ResponseEntity<Vehicle> addVehicle(
            @RequestHeader(value = ApiRestConstants.COUNTRY_CODE_HEADER) final String countryCode,
            @RequestHeader(value = ApiRestConstants.REQUEST_ID_HEADER) final String requestId,
            @RequestBody Vehicle vehicle);

    @DeleteMapping(ApiRestConstants.VEHICLES_ID)
    ResponseEntity<Void> deleteVehicle(
            @RequestHeader(value = ApiRestConstants.COUNTRY_CODE_HEADER) final String countryCode,
            @RequestHeader(value = ApiRestConstants.REQUEST_ID_HEADER) final String requestId,
            @PathVariable String vehicleId);
}
