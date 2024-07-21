package io.github.weidmann16.segurosbolivar.app.infrastructure.adapters.output.persistence.repository;

import io.github.weidmann16.segurosbolivar.app.infrastructure.adapters.output.persistence.entity.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<CharacterEntity, Long> {
}
