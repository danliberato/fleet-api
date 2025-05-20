package com.example.fleetapi.web.v1;

import com.example.fleetapi.domain.dto.route.Route;
import com.example.fleetapi.domain.rest.CreateRouteRequest;
import com.example.fleetapi.domain.rest.RouteResponse;
import com.example.fleetapi.domain.rest.UpdateRouteStatusRequest;
import com.example.fleetapi.usecase.driver.FindDriverUseCase;
import com.example.fleetapi.usecase.route.CreateRouteUseCase;
import com.example.fleetapi.usecase.route.UpdateRouteUseCase;
import com.example.fleetapi.usecase.vehicle.FindVehicleUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Controller
public class RouteControllerV1Impl implements RouteControllerV1 {

    private final CreateRouteUseCase createRouteUseCase;
    private final UpdateRouteUseCase updateRouteUseCase;
    private final FindDriverUseCase findDriverUseCase;
    private final FindVehicleUseCase findVehicleUseCase;

    public RouteControllerV1Impl(CreateRouteUseCase createRouteUseCase, UpdateRouteUseCase updateRouteUseCase, FindDriverUseCase findDriverUseCase, FindVehicleUseCase findVehicleUseCase) {
        this.createRouteUseCase = createRouteUseCase;
        this.updateRouteUseCase = updateRouteUseCase;
        this.findDriverUseCase = findDriverUseCase;
        this.findVehicleUseCase = findVehicleUseCase;
    }

    @Override
    public ResponseEntity<RouteResponse<Route>> createRoute(String countryCode, String requestId, CreateRouteRequest createRouteRequest) {
        return RouteResponse.created(createRouteUseCase.createRoute(createRouteRequest));
    }

    @Override
    public ResponseEntity<RouteResponse<Route>> updateRoute(String countryCode, String requestId, String routeId, UpdateRouteStatusRequest updateRouteStatusRequest) {
        return null;
    }
}
