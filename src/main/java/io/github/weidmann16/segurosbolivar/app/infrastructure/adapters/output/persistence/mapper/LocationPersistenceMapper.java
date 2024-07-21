package io.github.weidmann16.segurosbolivar.app.infrastructure.adapters.output.persistence.mapper;

import io.github.weidmann16.segurosbolivar.app.domain.model.Location;
import io.github.weidmann16.segurosbolivar.app.infrastructure.adapters.output.persistence.entity.LocationEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LocationPersistenceMapper {
    LocationEntity toLocationEntity(Location location);
    Location toLocation(LocationEntity entity);
    List<Location> toLocationList(List<LocationEntity> entityList);
}
