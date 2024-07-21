package io.github.weidmann16.segurosbolivar.app.application.ports.input;

import io.github.weidmann16.segurosbolivar.app.domain.model.Location;

import java.util.List;

public interface LocationServicePort {
    Location findById(Long id);
    List<Location> findAll();
    Location save(Location location);
    Location update(Long id, Location location);
    void deleteById(Long id);
}
