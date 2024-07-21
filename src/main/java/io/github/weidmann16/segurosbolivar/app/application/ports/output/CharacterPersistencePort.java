package io.github.weidmann16.segurosbolivar.app.application.ports.output;

import io.github.weidmann16.segurosbolivar.app.domain.model.Character;

import java.util.List;
import java.util.Optional;

public interface CharacterPersistencePort {
    Optional<Character> findById(Long id);

    List<Character> findAll();

    Character save(Character character);

    void deleteById(Long id);

  
}
