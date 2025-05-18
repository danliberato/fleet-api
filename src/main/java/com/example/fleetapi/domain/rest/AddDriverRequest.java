package com.example.fleetapi.domain.rest;

import com.example.fleetapi.domain.dto.driver.Driver;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
public class AddDriverRequest {

    private String name;
    private String documentNumber;
    private String email;
    private String phoneNumber;
    private String birthDate;
}
