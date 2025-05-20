package com.example.fleetapi.usecase.driver;


import com.example.fleetapi.domain.dto.driver.Driver;
import com.example.fleetapi.domain.exceptions.driver.DriverNotFoundException;
import com.example.fleetapi.infra.repository.driver.DriverRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class FindDriverUseCase{

    DriverRepository driverRepository;

    // Keeping multiple use cases in the same class for simplicity
    // Ideally, each use case should have its own class
    public FindDriverUseCase(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public Driver findDriverByDocument(String documentNumber) {
        return driverRepository.findByActiveAndDeletedAndDocumentNumber(true, false, documentNumber);
    }

    public Driver findActiveDriverById(String id) {
        Driver driver = driverRepository.findByActiveAndDeletedAndId(true, false, id);
        if (driver == null) {
            throw new DriverNotFoundException();
        }
        return driver;
    }

    public Page<Driver> findAllDrivers(String page, String pageSize) {
        Pageable pageable = Pageable.ofSize(Integer.parseInt(pageSize)).withPage(Integer.parseInt(page));
        return driverRepository.findAll(pageable);
    }


}
