package com.example.fleetapi.domain.rest;

import com.example.fleetapi.domain.dto.route.Route;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RouteResponse<T> {
    private T data;
    private String message;
    private int code;
    private long elements;
    private int totalPages;

    public static ResponseEntity<RouteResponse<Route>> success(Route data) {
        RouteResponse<Route> response = RouteResponse.<Route>builder()
                .message("Success")
                .code(0)
                .data(data)
                .build();
        return ResponseEntity.ok(response);
    }

    public static ResponseEntity<RouteResponse<List<Route>>> successList(List<Route> data, long elements, int totalPages) {
        RouteResponse<List<Route>> response = RouteResponse.<List<Route>>builder()
                .message("Success")
                .code(0)
                .elements(elements)
                .totalPages(totalPages)
                .data(data)
                .build();
        return ResponseEntity.ok(response);
    }

    public static ResponseEntity<RouteResponse<Route>> created(Route data) {
        RouteResponse<Route> response = RouteResponse.<Route>builder()
                .message("Success")
                .code(0)
                .data(data)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
