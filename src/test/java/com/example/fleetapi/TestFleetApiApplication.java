package com.example.fleetapi;

import org.springframework.boot.SpringApplication;

public class TestInterApiApplication {

    public static void main(String[] args) {
        SpringApplication.from(FleetApiApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
