package com.example.interapi.domain.dto.driver;

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
}
