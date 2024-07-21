package io.github.weidmann16.segurosbolivar.app.application.service;

import io.github.weidmann16.segurosbolivar.app.application.ports.input.CharacterServicePort;
import io.github.weidmann16.segurosbolivar.app.application.ports.output.CharacterPersistencePort;
import io.github.weidmann16.segurosbolivar.app.domain.exception.ApiNotFoundException;
import io.github.weidmann16.segurosbolivar.app.domain.model.Character;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CharacterService implements CharacterServicePort {

    private final CharacterPersistencePort persistencePort;

    @Override
    public Character findById(Long id) {
        return persistencePort.findById(id)
                .orElseThrow(ApiNotFoundException::new);
    }

    @Override
    public List<Character> findAll() {
        return persistencePort.findAll();
    }

    @Override
    public Character save(Character character) {
        return persistencePort.save(character);
    }

    @Override
    public Character update(Long id, Character character) {
        return persistencePort.findById(id)
                .map(savedCharacter -> {
                    savedCharacter.setName(character.getName());
                    savedCharacter.setStatus(character.getStatus());
                    savedCharacter.setSpecies(character.getSpecies());
                    savedCharacter.setType(character.getType());
                    savedCharacter.setGender(character.getGender());
                    savedCharacter.setOrigin(character.getOrigin());
                    savedCharacter.setLocation(character.getLocation());
                    savedCharacter.setImage(character.getImage());
                    savedCharacter.setEpisode(character.getEpisode());
                    savedCharacter.setUrl(character.getUrl());
                    savedCharacter.setCreated(character.getCreated());

                    return persistencePort.save(savedCharacter);
                })
                .orElseThrow(ApiNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        if (persistencePort.findById(id).isEmpty()) {
            throw new ApiNotFoundException();
        }

        persistencePort.deleteById(id);
    }
}
