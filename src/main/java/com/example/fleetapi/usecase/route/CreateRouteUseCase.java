package com.example.fleetapi.usecase.route;

import com.example.fleetapi.domain.dto.driver.Driver;
import com.example.fleetapi.domain.dto.route.Route;
import com.example.fleetapi.domain.dto.route.RouteStatus;
import com.example.fleetapi.domain.dto.vehicle.Vehicle;
import com.example.fleetapi.domain.exceptions.driver.DriverNotFoundException;
import com.example.fleetapi.domain.exceptions.vehicle.VehicleNotFoundException;
import com.example.fleetapi.domain.rest.CreateRouteRequest;
import com.example.fleetapi.infra.repository.driver.DriverRepository;
import com.example.fleetapi.infra.repository.route.RouteRepository;
import com.example.fleetapi.infra.repository.vehicle.VehicleRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CreateRouteUseCase {

    private final RouteRepository routeRepository;
    private final VehicleRepository vehicleRepository;
    private final DriverRepository driverRepository;

    public CreateRouteUseCase(RouteRepository routeRepository, VehicleRepository vehicleRepository, DriverRepository driverRepository) {
        this.routeRepository = routeRepository;
        this.vehicleRepository = vehicleRepository;
        this.driverRepository = driverRepository;
    }

    public Route createRoute(CreateRouteRequest createRouteRequest) {
        if(!driverRepository.existsById(createRouteRequest.getDriverId())) {
            throw new DriverNotFoundException();
        };

        Vehicle vehicle = vehicleRepository.findDriverByActiveAndDeletedAndId(true, false, createRouteRequest.getVehicleId());
        if (vehicle == null) {
            throw new VehicleNotFoundException();
        }

        Route newRoute = Route.builder()
                .id(java.util.UUID.randomUUID().toString())
                .name(createRouteRequest.getName())
                .description(createRouteRequest.getDescription())
                .departureTime(LocalDateTime.now())
                .originAddress(createRouteRequest.getOriginAddress())
                .destinationAddress(createRouteRequest.getDestinationAddress())
                .driverId(createRouteRequest.getDriverId())
                .vehicle(vehicle)
                .lastStatus(RouteStatus.STARTED)
                .build();
        return routeRepository.save(newRoute);
    }
}
