package com.example.interapi.infra;

public final class ApiRestConstants {

    public static final String API_VERSION = "/api/v1";
    public static final String API_VERSION_2 = "/api/v2";

    public static final String DRIVERS = "/drivers";
    public static final String DRIVERS_ID = "/drivers/{id}";
    public static final String DRIVERS_ID_VEHICLES = "/drivers/{driverId}/vehicles";
    public static final String DRIVERS_ID_VEHICLES_ID = "/drivers/{driverId}/vehicles/{vehicleId}";

    public static final String VEHICLES = "/vehicles";
    public static final String VEHICLES_ID = "/vehicles/{vehicleId}";

    public static final String ROUTES = "/routes";
    public static final String ROUTES_ID = "/routes/{routeId}";

    public static final String FLEETS = "/fleets";
    public static final String FLEETS_ID = "/fleets/{fleetId}";
    public static final String FLEETS_ID_VEHICLES = "/fleets/{fleetId}/vehicles";

    //HEADERS
    public static final String REQUEST_ID_HEADER = "X-Request-ID";
    public static final String COUNTRY_CODE_HEADER = "X-Country-Code";
}
