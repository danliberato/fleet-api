package com.example.interapi.infra.repository;

import com.example.interapi.domain.dto.driver.Driver;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "drivers", path = "drivers")
public interface DriverRepository extends MongoRepository<Driver, String> {

    Driver findByDocumentNumber(String documentNumber);

    Driver findDriverByActiveAndId(boolean active, UUID id);

    @NotNull
    Page<Driver> findAll(@NotNull Pageable pageable);

    Driver updateDriver(Driver driver);

}
