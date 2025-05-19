package com.example.fleetapi.usecase.vehicle;

import com.example.fleetapi.domain.dto.driver.Driver;
import com.example.fleetapi.domain.dto.vehicle.Vehicle;
import com.example.fleetapi.domain.exceptions.driver.DriverNotFoundException;
import com.example.fleetapi.domain.exceptions.vehicle.VehicleNotFoundException;
import com.example.fleetapi.infra.repository.driver.DriverRepository;
import com.example.fleetapi.infra.repository.vehicle.VehicleRepository;
import org.springframework.stereotype.Component;

@Component
public class AssignVehicleToDriverUseCase {

    private final VehicleRepository vehicleRepository;
    private final DriverRepository driverRepository;

    public AssignVehicleToDriverUseCase(VehicleRepository vehicleRepository, DriverRepository driverRepository) {
        this.vehicleRepository = vehicleRepository;
        this.driverRepository = driverRepository;
    }

    /*
     * Constraints:
     * - The driver must exist
     * - The vehicle must exist
     * - The driver must not be inactive
     * - The driver must not be deleted
     * - The vehicle must not be inactive
     * - The vehicle must not be assigned to another driver
     */

    public Vehicle assignVehicleToDriver(String driverId, String vehicleId) {
        Driver driver = driverRepository.findDriverByActiveAndDeletedAndId(true, false, driverId);
        if (driver == null) {
            throw new DriverNotFoundException();
        }
        Vehicle vehicle = vehicleRepository.findDriverByActiveAndDeletedAndId(true, false, vehicleId);
        if (vehicle == null) {
            throw new VehicleNotFoundException();
        }
        vehicle.setDriverId(driver.getId());
        vehicleRepository.save(vehicle);
        return vehicle;
    }
}
