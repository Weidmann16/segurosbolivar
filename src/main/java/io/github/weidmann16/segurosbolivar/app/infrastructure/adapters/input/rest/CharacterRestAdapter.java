package io.github.weidmann16.segurosbolivar.app.infrastructure.adapters.input.rest;

import io.github.weidmann16.segurosbolivar.app.application.ports.input.CharacterServicePort;
import io.github.weidmann16.segurosbolivar.app.infrastructure.adapters.input.rest.mapper.CharacterRestMapper;
import io.github.weidmann16.segurosbolivar.app.infrastructure.adapters.input.rest.model.request.CharacterCreateRequest;
import io.github.weidmann16.segurosbolivar.app.infrastructure.adapters.input.rest.model.response.CharacterResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/characters")
public class CharacterRestAdapter {

  private final CharacterServicePort servicePort;
  private final CharacterRestMapper restMapper;

  @GetMapping
  public List<CharacterResponse> findAll() {
    return restMapper.toCharacterResponseList(servicePort.findAll());
  }

  @GetMapping("/{id}")
  public CharacterResponse findById(@PathVariable Long id) {
    return restMapper.toCharacterResponse(servicePort.findById(id));
  }

  @PostMapping
  public ResponseEntity<CharacterResponse> save(@Valid @RequestBody CharacterCreateRequest request) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(restMapper.toCharacterResponse(
            servicePort.save(restMapper.toCharacter(request))));
  }

  @PutMapping("/{id}")
  public CharacterResponse update(@PathVariable Long id, @Valid @RequestBody CharacterCreateRequest request) {
    return restMapper.toCharacterResponse(
        servicePort.update(id, restMapper.toCharacter(request)));
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    servicePort.deleteById(id);
  }
}
