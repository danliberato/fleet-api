package com.example.interapi.usecase.driver;


import com.example.interapi.domain.dto.driver.Driver;
import com.example.interapi.infra.repository.DriverRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class FindDriverUseCase{

    DriverRepository driverRepository;

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

    public Page<Driver> findAllDrivers(Pageable pageable) {
        return driverRepository.findAll(pageable);
    }


}
