package com.example.fleetapi.usecase.vehicle;

import com.example.fleetapi.domain.dto.vehicle.Vehicle;
import com.example.fleetapi.infra.repository.vehicle.VehicleRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindVehicleUseCase {

    private final VehicleRepository vehicleRepository;

    public FindVehicleUseCase(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> findByDriverId(String driverId) {
        return vehicleRepository.findByDriverId(driverId);
    }
}
