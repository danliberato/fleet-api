package com.example.fleetapi.usecase.vehicle;

import com.example.fleetapi.domain.dto.vehicle.Vehicle;
import com.example.fleetapi.domain.dto.vehicle.VehicleStatus;
import com.example.fleetapi.domain.rest.AddVehicleRequest;
import com.example.fleetapi.infra.repository.vehicle.VehicleRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AddVehicleUseCase {

    private final VehicleRepository vehicleRepository;

    public AddVehicleUseCase(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle addVehicle(AddVehicleRequest addVehicleRequest) {
        Vehicle driver = Vehicle.builder()
                .id(UUID.randomUUID().toString())
                .licensePlate(addVehicleRequest.getLicensePlate())
                .registrationNumber(addVehicleRequest.getRegistrationNumber())
                .status(VehicleStatus.AVAILABLE)
                .brand(addVehicleRequest.getBrand())
                .model(addVehicleRequest.getModel())
                .year(addVehicleRequest.getYear())
                .color(addVehicleRequest.getColor())
                .weightKg(addVehicleRequest.getWeightKg())
                .seatingCapacity(addVehicleRequest.getSeatingCapacity())
                .cargoCapacityKg(addVehicleRequest.getCargoCapacityKg())
                .vehicleType(addVehicleRequest.getVehicleType())
                .totalDistanceTraveledKm(0)
                .totalTripsCompleted(0)
                .active(true)
                .deleted(false)
                .build();
        return AddVehicleUseCase.this.vehicleRepository.save(driver);

    }
}
