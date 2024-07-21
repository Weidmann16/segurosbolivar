package io.github.weidmann16.segurosbolivar.app.domain.model;

import java.util.List; 

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Character {
    
    private Long id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private Origin origin;
    private Location location;
    private String image;
    private List<String> episode;
    private String url;
    private String created;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Origin {
        private String name;
        private String url;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Location {
        private String name;
        private String url;
    }
}
