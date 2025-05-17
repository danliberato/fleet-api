package com.example.interapi.usecase.driver;


import com.example.interapi.domain.dto.driver.Driver;
import com.example.interapi.infra.repository.DriverRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindDriverUseCase{

    DriverRepository driverRepository;

    // Keeping multiple use cases in the same class for simplicity
    // Ideally, each use case should have its own class
    public FindDriverUseCase(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public Driver findDriverByDocument(String documentNumber) {
        return driverRepository.findByDocumentNumber(documentNumber);
    }

    public Driver findDriverById(String id) {
        Optional<Driver> optionalDriver = driverRepository.findById(id);
        return optionalDriver.orElse(null);
    }

    public Page<Driver> findAllDrivers(String page, String pageSize) {
        Pageable pageable = Pageable.ofSize(Integer.parseInt(pageSize)).withPage(Integer.parseInt(page));
        return driverRepository.findAll(pageable);
    }


}
