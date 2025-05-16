package com.example.interapi;

import org.springframework.boot.SpringApplication;

public class TestInterApiApplication {

    public static void main(String[] args) {
        SpringApplication.from(InterApiApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
