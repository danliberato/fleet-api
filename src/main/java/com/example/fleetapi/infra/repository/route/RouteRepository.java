package com.example.fleetapi.infra.repository.route;

import com.example.fleetapi.domain.dto.route.Route;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RouteRepository extends MongoRepository<Route, String> {

    @NotNull Optional<Route> findById(@NotNull String id);
}
