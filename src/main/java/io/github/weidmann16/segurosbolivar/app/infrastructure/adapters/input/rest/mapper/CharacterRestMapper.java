package io.github.weidmann16.segurosbolivar.app.infrastructure.adapters.input.rest.mapper;

import io.github.weidmann16.segurosbolivar.app.domain.model.Character;
import io.github.weidmann16.segurosbolivar.app.infrastructure.adapters.input.rest.model.request.CharacterCreateRequest;
import io.github.weidmann16.segurosbolivar.app.infrastructure.adapters.input.rest.model.response.CharacterResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CharacterRestMapper {

  Character toCharacter(CharacterCreateRequest request);

  CharacterResponse toCharacterResponse(Character character);

  List<CharacterResponse> toCharacterResponseList(List<Character> characterList);
}
