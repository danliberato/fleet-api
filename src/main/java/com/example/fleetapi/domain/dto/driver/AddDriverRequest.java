package com.example.fleetapi.domain.dto.driver;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AddDriverRequest {

    private String name;
    private String documentNumber;
    private String email;
    private String phoneNumber;
    private String birthDate;

    public Driver toDriver() {
        Driver driver = new Driver();
        driver.setName(name);
        driver.setDocumentNumber(documentNumber);
        driver.setEmail(email);
        driver.setPhoneNumber(phoneNumber);
        driver.setBirthDate(birthDate);
        return driver;
    }
}
