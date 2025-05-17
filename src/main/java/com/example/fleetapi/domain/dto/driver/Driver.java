package com.example.interapi.domain.dto.driver;

import com.example.interapi.domain.dto.vehicle.Vehicle;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Driver {

    @Id private UUID id;
    private String name;
    private String documentNumber;
    private String email;
    private String phoneNumber;
    private String birthDate;
    private boolean isActive;
    private boolean isDeleted;
    private List<Vehicle> vehicles;

    public Driver() {
    }
}
