package io.github.weidmann16.segurosbolivar.app.infrastructure.adapters.output.persistence;

import io.github.weidmann16.segurosbolivar.app.application.ports.output.CharacterPersistencePort;
import io.github.weidmann16.segurosbolivar.app.domain.model.Character;
import io.github.weidmann16.segurosbolivar.app.infrastructure.adapters.output.persistence.entity.CharacterEntity;
import io.github.weidmann16.segurosbolivar.app.infrastructure.adapters.output.persistence.mapper.CharacterPersistenceMapper;
import io.github.weidmann16.segurosbolivar.app.infrastructure.adapters.output.persistence.repository.CharacterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CharacterPersistenceAdapter implements CharacterPersistencePort {

    private final CharacterRepository repository;
    private final CharacterPersistenceMapper mapper;

    @Override
    public Optional<Character> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toCharacter);
    }

    @Override
    public List<Character> findAll() {
        return mapper.toCharacterList(repository.findAll());
    }

    @Override
    public Character save(Character character) {
        CharacterEntity entity = mapper.toCharacterEntity(character);
        CharacterEntity savedEntity = repository.save(entity);
        return mapper.toCharacter(savedEntity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
