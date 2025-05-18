package com.example.fleetapi.usecase.driver;

import com.example.fleetapi.domain.dto.driver.Driver;
import com.example.fleetapi.domain.dto.vehicle.Vehicle;
import com.example.fleetapi.domain.exceptions.driver.DriverInRouteException;
import com.example.fleetapi.domain.exceptions.driver.DriverNotFoundException;
import com.example.fleetapi.infra.repository.driver.DriverRepository;
import com.example.fleetapi.infra.repository.vehicle.VehicleRepository;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class DeleteDriverUseCase {


    private final DriverRepository driverRepository;
    private final VehicleRepository vehicleRepository;

    public DeleteDriverUseCase(DriverRepository driverRepository, VehicleRepository vehicleRepository) {
        this.driverRepository = driverRepository;
        this.vehicleRepository = vehicleRepository;
    }

    public void deleteDriver(String id) {
        Driver driver = driverRepository.findDriverByActiveAndDeletedAndId(true, false, id);
        validateDriverDeletion(driver);
        driverRepository.deleteDriver(id);
    }

    private void validateDriverDeletion(Driver driver) {
        if (driver == null) {
            throw (new DriverNotFoundException());
        }
        //ToDo: check if driver is assigned to any route
        //ToDo: check if driver's vehicles are assigned to any route
        //Check if driver's vehicles are in status = IN_USE
        List<Vehicle> vehicleList = vehicleRepository.findByDriver(driver);
        if (!vehicleList.isEmpty()) {
            throw (new DriverInRouteException());
        }
    }

}
