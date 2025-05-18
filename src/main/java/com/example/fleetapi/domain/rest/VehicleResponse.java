package com.example.fleetapi.domain.rest;

import com.example.fleetapi.domain.dto.vehicle.Vehicle;
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
public class VehicleResponse<T> {
    private String message;
    private int code;
    private T data;

    public static ResponseEntity<VehicleResponse<Vehicle>> success(Vehicle data) {
        VehicleResponse<Vehicle> response = VehicleResponse.<Vehicle>builder()
                .message("Success")
                .code(0)
                .data(data)
                .build();
        return ResponseEntity.ok(response);
    }

    public static ResponseEntity<VehicleResponse<List<Vehicle>>> successList(List<Vehicle> data) {
        VehicleResponse<List<Vehicle>> response = VehicleResponse.<List<Vehicle>>builder()
                .message("Success")
                .code(0)
                .data(data)
                .build();
        return ResponseEntity.ok(response);
    }

    public static ResponseEntity<VehicleResponse<Vehicle>> created(Vehicle data) {
        VehicleResponse<Vehicle> response = VehicleResponse.<Vehicle>builder()
                .message("Success")
                .code(0)
                .data(data)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    public static ResponseEntity<VehicleResponse<Vehicle>> successEmpty() {
        VehicleResponse<Vehicle> response = VehicleResponse.<Vehicle>builder()
                .message("Success")
                .code(0)
                .build();
        return ResponseEntity.ok(response);
    }

    //ERROR scenarios are handled by global exception handler
}
