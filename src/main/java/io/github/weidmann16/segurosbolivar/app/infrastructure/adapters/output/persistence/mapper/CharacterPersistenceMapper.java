package io.github.weidmann16.segurosbolivar.app.infrastructure.adapters.output.persistence.mapper;

import io.github.weidmann16.segurosbolivar.app.domain.model.Character;
import io.github.weidmann16.segurosbolivar.app.infrastructure.adapters.output.persistence.entity.CharacterEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CharacterPersistenceMapper {
    CharacterEntity toCharacterEntity(Character character);
    Character toCharacter(CharacterEntity characterEntity);
    List<Character> toCharacterList(List<CharacterEntity> characterEntities);
}
