package io.github.weidmann16.segurosbolivar.app.application.ports.input;

import io.github.weidmann16.segurosbolivar.app.domain.model.Character;

import java.util.List;

public interface CharacterServicePort {

  Character findById(Long id);

  List<Character> findAll();

  Character save(Character location);

  Character update(Long id, Character location);

  void deleteById(Long id);

}
