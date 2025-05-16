package com.example.interapi.infra.repository;

import com.example.interapi.domain.dto.driver.Driver;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "drivers", path = "drivers")
public interface DriverRepository extends MongoRepository<Driver, String> {

    Driver findByDocumentNumber(String documentNumber);

    @NotNull
    Page<Driver> findAll(@NotNull Pageable pageable);

}
