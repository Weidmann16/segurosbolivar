package io.github.weidmann16.segurosbolivar.app.application.ports.output;

import io.github.weidmann16.segurosbolivar.app.domain.model.Location;

import java.util.List;
import java.util.Optional;

public interface LocationPersistencePort {
    Optional<Location> findById(Long id);

    List<Location> findAll();

    Location save(Location location);

    void deleteById(Long id);
}
