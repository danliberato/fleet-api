package com.example.fleetapi.web.v1;

import com.example.fleetapi.domain.dto.route.Route;
import com.example.fleetapi.domain.rest.CreateRouteRequest;
import com.example.fleetapi.domain.rest.RouteResponse;
import com.example.fleetapi.domain.rest.UpdateRouteStatusRequest;
import com.example.fleetapi.infra.ApiRestConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = ApiRestConstants.API_VERSION, produces = "application/json", consumes = "application/json")
public interface RouteControllerV1 {

    @PostMapping(ApiRestConstants.ROUTES)
    ResponseEntity<RouteResponse<Route>> createRoute(
            @RequestHeader(value = ApiRestConstants.COUNTRY_CODE_HEADER) final String countryCode,
            @RequestHeader(value = ApiRestConstants.REQUEST_ID_HEADER) final String requestId,
            @RequestBody CreateRouteRequest createRouteRequest);

    @PatchMapping(ApiRestConstants.ROUTES_ID)
    ResponseEntity<RouteResponse<Route>> updateRoute(
            @RequestHeader(value = ApiRestConstants.COUNTRY_CODE_HEADER) final String countryCode,
            @RequestHeader(value = ApiRestConstants.REQUEST_ID_HEADER) final String requestId,
            @PathVariable String routeId,
            @RequestBody UpdateRouteStatusRequest updateRouteStatusRequest);
}
