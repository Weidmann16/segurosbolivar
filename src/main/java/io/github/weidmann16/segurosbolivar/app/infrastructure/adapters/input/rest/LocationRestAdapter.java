package io.github.weidmann16.segurosbolivar.app.infrastructure.adapters.input.rest;

import io.github.weidmann16.segurosbolivar.app.application.ports.input.LocationServicePort;
import io.github.weidmann16.segurosbolivar.app.infrastructure.adapters.input.rest.mapper.LocationRestMapper;
import io.github.weidmann16.segurosbolivar.app.infrastructure.adapters.input.rest.model.request.LocationCreateRequest;
import io.github.weidmann16.segurosbolivar.app.infrastructure.adapters.input.rest.model.response.LocationResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/locations")
public class LocationRestAdapter {

    private final LocationServicePort servicePort;
    private final LocationRestMapper restMapper;

    @GetMapping
    public List<LocationResponse> findAll() {
        return restMapper.toLocationResponseList(servicePort.findAll());
    }

    @GetMapping("/{id}")
    public LocationResponse findById(@PathVariable Long id) {
        return restMapper.toLocationResponse(servicePort.findById(id));
    }

    @PostMapping
    public ResponseEntity<LocationResponse> save(@Valid @RequestBody LocationCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(restMapper.toLocationResponse(
                        servicePort.save(restMapper.toLocation(request))));
    }

    @PutMapping("/{id}")
    public LocationResponse update(@PathVariable Long id, @Valid @RequestBody LocationCreateRequest request) {
        return restMapper.toLocationResponse(
                servicePort.update(id, restMapper.toLocation(request)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        servicePort.deleteById(id);
    }
}
