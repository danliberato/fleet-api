package com.example.fleetapi.domain.dto.route;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder(toBuilder = true)
public class RouteEvent {
    private String id;
    private LocalDateTime timestamp;
    private RouteStatus status;

    public RouteEvent(LocalDateTime timestamp, RouteStatus status) {
        this.timestamp = timestamp;
        this.status = status;
    }

    public RouteEvent build() {
        this.id = java.util.UUID.randomUUID().toString();
        return toBuilder().build();
    }
}
