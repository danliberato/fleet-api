package com.example.fleetapi.domain.dto.driver;

import com.example.fleetapi.domain.dto.vehicle.Vehicle;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Driver {

    @Id private String id;
    private String name;
    private String documentNumber;
    private String email;
    private String phoneNumber;
    //Todo: Change to LocalDate
    private String birthDate;
    private boolean active;
    private boolean deleted;
    private List<Vehicle> vehicles;

    // Timestamps
    private String createdAt;
    @LastModifiedDate
    private String updatedAt;

}
