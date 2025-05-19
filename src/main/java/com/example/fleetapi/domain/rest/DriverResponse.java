package com.example.fleetapi.domain.rest;

import com.example.fleetapi.domain.dto.driver.Driver;
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
public class DriverResponse<T> {
    private T data;
    private String message;
    private int code;
    private long elements;
    private int totalPages;

    public static ResponseEntity<DriverResponse<Driver>> success(Driver data) {
        DriverResponse<Driver> response = DriverResponse.<Driver>builder()
                .message("Success")
                .code(0)
                .data(data)
                .build();
        return ResponseEntity.ok(response);
    }

    public static ResponseEntity<DriverResponse<List<Driver>>> successList(List<Driver> data, long elements, int totalPages) {
        DriverResponse<List<Driver>> response = DriverResponse.<List<Driver>>builder()
                .message("Success")
                .code(0)
                .elements(elements)
                .totalPages(totalPages)
                .data(data)
                .build();
        return ResponseEntity.ok(response);
    }

    public static ResponseEntity<DriverResponse<Driver>> created(Driver data) {
        DriverResponse<Driver> response = DriverResponse.<Driver>builder()
                .message("Success")
                .code(0)
                .data(data)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    public static ResponseEntity<DriverResponse<Driver>> successEmpty() {
        DriverResponse<Driver> response = DriverResponse.<Driver>builder()
                .message("Success")
                .code(0)
                .build();
        return ResponseEntity.ok(response);
    }

    //ERROR scenarios are handled by global exception handler
}
