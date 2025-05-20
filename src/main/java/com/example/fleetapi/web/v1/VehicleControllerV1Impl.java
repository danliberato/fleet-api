package com.example.fleetapi.web.v1;

import com.example.fleetapi.domain.dto.vehicle.Vehicle;
import com.example.fleetapi.domain.rest.AddVehicleRequest;
import com.example.fleetapi.domain.rest.VehicleResponse;
import com.example.fleetapi.usecase.vehicle.AddVehicleUseCase;
import com.example.fleetapi.usecase.vehicle.AssignVehicleToDriverUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class VehicleControllerV1Impl implements VehicleControllerV1 {

    private final AddVehicleUseCase addVehicleUseCase;
    private final AssignVehicleToDriverUseCase assignVehicleToDriverUseCase;

    public VehicleControllerV1Impl(AddVehicleUseCase addVehicleUseCase, AssignVehicleToDriverUseCase assignVehicleToDriverUseCase) {
        this.addVehicleUseCase = addVehicleUseCase;
        this.assignVehicleToDriverUseCase = assignVehicleToDriverUseCase;
    }

    @Override
    public ResponseEntity<VehicleResponse<List<Vehicle>>> getAllVehicles(String countryCode, String requestId, String page, String pageSize) {
        return null;
    }

    @Override
    public ResponseEntity<VehicleResponse<Vehicle>> addVehicle(String countryCode, String requestId, AddVehicleRequest addVehicleRequest) {
        Vehicle vehicle = this.addVehicleUseCase.addVehicle(addVehicleRequest);
        return VehicleResponse.created(vehicle);
    }

    @Override
    public ResponseEntity<VehicleResponse<Void>> deleteVehicle(String countryCode, String requestId, String vehicleId) {
        return null;
    }

    @Override
    public ResponseEntity<VehicleResponse<Vehicle>> UpdateDriverVehicle(String countryCode, String requestId, String driverId, String vehicleId) {
        Vehicle vehicle = this.assignVehicleToDriverUseCase.assignVehicleToDriver(driverId, vehicleId);
        return VehicleResponse.success(vehicle);
    }
}
