package io.github.weidmann16.segurosbolivar.app.infrastructure.adapters.input.rest.model.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LocationResponse {

  private Long id;
  private String name;
  private String type;
  private String dimension;
  private List<String> residents;
  private String url;
  private String created;
}
