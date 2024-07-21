package io.github.weidmann16.segurosbolivar.app.infrastructure.adapters.output.persistence;

import io.github.weidmann16.segurosbolivar.app.application.ports.output.LocationPersistencePort;
import io.github.weidmann16.segurosbolivar.app.domain.model.Location;
import io.github.weidmann16.segurosbolivar.app.infrastructure.adapters.output.persistence.mapper.LocationPersistenceMapper;
import io.github.weidmann16.segurosbolivar.app.infrastructure.adapters.output.persistence.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class LocationPersistenceAdapter implements LocationPersistencePort {

  private final LocationRepository repository;
  private final LocationPersistenceMapper mapper;

  @Override
  public Optional<Location> findById(Long id) {
    return repository.findById(id)
        .map(mapper::toLocation);
  }

  @Override
  public List<Location> findAll() {
    return mapper.toLocationList(repository.findAll());
  }

  @Override
  public Location save(Location location) {
    return mapper.toLocation(
        repository.save(mapper.toLocationEntity(location)));
  }

  @Override
  public void deleteById(Long id) {
    repository.deleteById(id);
  }
}
