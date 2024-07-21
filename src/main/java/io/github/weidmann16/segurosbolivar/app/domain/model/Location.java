package io.github.weidmann16.segurosbolivar.app.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    private Long id;
    private String name;
    private String type;
    private String dimension;
    private String[] residents;
    private String url;
    private String created;
}
