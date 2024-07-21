package io.github.weidmann16.segurosbolivar.app.infrastructure.adapters.input.rest.mapper;

import io.github.weidmann16.segurosbolivar.app.domain.model.Location;
import io.github.weidmann16.segurosbolivar.app.infrastructure.adapters.input.rest.model.request.LocationCreateRequest;
import io.github.weidmann16.segurosbolivar.app.infrastructure.adapters.input.rest.model.response.LocationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LocationRestMapper {

    Location toLocation(LocationCreateRequest request);

    LocationResponse toLocationResponse(Location location);

    List<LocationResponse> toLocationResponseList(List<Location> locationList);
}
