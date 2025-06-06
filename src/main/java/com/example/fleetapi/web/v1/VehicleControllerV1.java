package com.example.fleetapi.web.v1;

import com.example.fleetapi.domain.dto.vehicle.Vehicle;
import com.example.fleetapi.domain.rest.AddVehicleRequest;
import com.example.fleetapi.domain.rest.VehicleResponse;
import com.example.fleetapi.infra.ApiRestConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = ApiRestConstants.API_VERSION, produces = "application/json", consumes = "application/json")
public interface VehicleControllerV1 {

    @GetMapping(ApiRestConstants.VEHICLES)
    ResponseEntity<VehicleResponse<List<Vehicle>>> getAllVehicles(
            @RequestHeader(value = ApiRestConstants.COUNTRY_CODE_HEADER) final String countryCode,
            @RequestHeader(value = ApiRestConstants.REQUEST_ID_HEADER) final String requestId,
            @RequestParam(value = "page", required = false, defaultValue = "0") final String page,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") final String pageSize
    );

    @PostMapping(ApiRestConstants.VEHICLES)
    ResponseEntity<VehicleResponse<Vehicle>> addVehicle(
            @RequestHeader(value = ApiRestConstants.COUNTRY_CODE_HEADER) final String countryCode,
            @RequestHeader(value = ApiRestConstants.REQUEST_ID_HEADER) final String requestId,
            @RequestBody AddVehicleRequest addVehicleRequest);

    @DeleteMapping(ApiRestConstants.VEHICLES_ID)
    ResponseEntity<VehicleResponse<Void>> deleteVehicle(
            @RequestHeader(value = ApiRestConstants.COUNTRY_CODE_HEADER) final String countryCode,
            @RequestHeader(value = ApiRestConstants.REQUEST_ID_HEADER) final String requestId,
            @PathVariable String vehicleId);

    @PatchMapping(ApiRestConstants.DRIVERS_ID_VEHICLES_ID)
    ResponseEntity<VehicleResponse<Vehicle>> UpdateDriverVehicle(
            @RequestHeader(value = ApiRestConstants.COUNTRY_CODE_HEADER) final String countryCode,
            @RequestHeader(value = ApiRestConstants.REQUEST_ID_HEADER) final String requestId,
            @PathVariable String driverId, @PathVariable String vehicleId);
}
