package io.github.weidmann16.segurosbolivar.app.application.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import io.github.weidmann16.segurosbolivar.app.infrastructure.adapters.input.rest.model.response.CharacterApiExtResponse;
import io.github.weidmann16.segurosbolivar.app.infrastructure.adapters.input.rest.model.response.LocationApiExtResponse;
import io.github.weidmann16.segurosbolivar.app.infrastructure.adapters.input.rest.model.response.CharacterResponse;
import io.github.weidmann16.segurosbolivar.app.infrastructure.adapters.output.persistence.entity.CharacterEntity;
import io.github.weidmann16.segurosbolivar.app.infrastructure.adapters.output.persistence.entity.LocationEntity;
import io.github.weidmann16.segurosbolivar.app.infrastructure.adapters.input.rest.model.response.LocationResponse;

import io.github.weidmann16.segurosbolivar.app.infrastructure.adapters.output.persistence.repository.CharacterRepository;
import io.github.weidmann16.segurosbolivar.app.infrastructure.adapters.output.persistence.repository.LocationRepository;

import lombok.RequiredArgsConstructor;

import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RickAndMortyService {

    private final CharacterRepository repositoryCharacter;
    private final LocationRepository repositoryLocation;

    public void fetchAndSaveData() {
        System.out.println("Fetching data from Rick and Morty API");

        this.getAllLocations();
        this.getAllCharacters();

        System.out.println("Data fetched from Rick and Morty API");
    }

    public Mono<CharacterApiExtResponse> getAllCharactersByPages(String url) {
        WebClient client = WebClient.builder()
                .baseUrl(url)
                .defaultCookie("cookieKey", "cookieValue")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultUriVariables(Collections.singletonMap("url", url))
                .build();

        Mono<CharacterApiExtResponse> characterResponse = client.get().retrieve()
                .bodyToMono(CharacterApiExtResponse.class);

        return characterResponse;
    }

    public Mono<LocationApiExtResponse> getAllLocationsByPages(String url) {
        WebClient client = WebClient.builder()
                .baseUrl(url)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultUriVariables(Collections.singletonMap("url", url))
                .build();

        Mono<LocationApiExtResponse> locationResponse = client.get().retrieve()
                .bodyToMono(LocationApiExtResponse.class);

        return locationResponse;
    }

    public void getAllCharacters() {
        Mono<CharacterApiExtResponse> characterResponse;
        String url = "https://rickandmortyapi.com/api/character";

        int countPage = 1;

        while (url != null) {
            characterResponse = getAllCharactersByPages(url);

            System.out.println("Current page: " + countPage + " of " + characterResponse.block().getInfo().getPages());

            List<CharacterEntity> charactersAll = new ArrayList<>();
            List<CharacterResponse> characters = characterResponse.block().getResults();

            for (CharacterResponse character : characters) {
                charactersAll.add(
                        new CharacterEntity(
                                character.getId(),
                                character.getName(),
                                character.getStatus(),
                                character.getSpecies(),
                                character.getType(),
                                character.getGender(),
                                new CharacterEntity.OriginEntity(
                                        character.getOrigin().getName(),
                                        character.getOrigin().getUrl()),
                                new CharacterEntity.LocationEntity(
                                        character.getLocation().getName(),
                                        character.getLocation().getUrl()),
                                character.getImage(),
                                character.getEpisode(),
                                character.getUrl(),
                                character.getCreated()));
                url = characterResponse.block().getInfo().getNext();
            }
            countPage++;
            repositoryCharacter.saveAll(charactersAll);
        }
    }

    public void getAllLocations() {
        Mono<LocationApiExtResponse> locationResponse;
        String url = "https://rickandmortyapi.com/api/location";

        int countPage = 1;

        while (url != null) {
            locationResponse = getAllLocationsByPages(url);

            List<LocationEntity> locationsAll = new ArrayList<>();
            
            System.out.println("Current page: " + countPage + " of " + locationResponse.block().getInfo().getPages());

            List<LocationResponse> locations = locationResponse.block().getResults();
            for (LocationResponse location : locations) {
                locationsAll.add(
                        new LocationEntity(
                                location.getId(),
                                location.getName(),
                                location.getType(),
                                location.getDimension(),
                                location.getResidents(),
                                location.getUrl(),
                                location.getCreated()));

                url = locationResponse.block().getInfo().getNext();
            }
            countPage++;
            repositoryLocation.saveAll(locationsAll);
        }
    }
}