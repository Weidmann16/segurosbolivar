package io.github.weidmann16.segurosbolivar.app.application.service;

import io.github.weidmann16.segurosbolivar.app.application.ports.input.LocationServicePort;
import io.github.weidmann16.segurosbolivar.app.application.ports.output.LocationPersistencePort;
import io.github.weidmann16.segurosbolivar.app.domain.exception.ApiNotFoundException;

import io.github.weidmann16.segurosbolivar.app.domain.model.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService implements LocationServicePort {

    private final LocationPersistencePort persistencePort;

    @Override
    public Location findById(Long id) {
        return persistencePort.findById(id)
                .orElseThrow(ApiNotFoundException::new);
    }

    @Override
    public List<Location> findAll() {
        return persistencePort.findAll();
    }

    @Override
    public Location save(Location location) {
        return persistencePort.save(location);
    }

    @Override
    public Location update(Long id, Location location) {
        return persistencePort.findById(id)
                .map(savedLocation -> {
                    savedLocation.setName(location.getName());
                    savedLocation.setType(location.getType());
                    savedLocation.setDimension(location.getDimension());
                    savedLocation.setResidents(location.getResidents());
                    savedLocation.setUrl(location.getUrl());
                    savedLocation.setCreated(location.getCreated());

                    return persistencePort.save(savedLocation);
                })
                .orElseThrow(ApiNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        if (persistencePort.findById(id).isEmpty()) {
            throw new ApiNotFoundException();
        }

        persistencePort.deleteById(id);
    }
}
