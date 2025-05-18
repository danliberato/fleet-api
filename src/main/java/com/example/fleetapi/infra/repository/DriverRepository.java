package com.example.fleetapi.infra.repository;

import com.example.fleetapi.domain.dto.driver.Driver;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends MongoRepository<Driver, String>, DriverRepositoryCustom {

    Driver findByDocumentNumber(String documentNumber);

    Driver findDriverByActiveAndId(boolean active, String id);

    @NotNull
    Page<Driver> findAll(@NotNull Pageable pageable);

}
