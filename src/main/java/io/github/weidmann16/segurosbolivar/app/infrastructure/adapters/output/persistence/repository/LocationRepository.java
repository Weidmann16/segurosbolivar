package io.github.weidmann16.segurosbolivar.app.infrastructure.adapters.output.persistence.repository;

import io.github.weidmann16.segurosbolivar.app.infrastructure.adapters.output.persistence.entity.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<LocationEntity, Long> {
}
