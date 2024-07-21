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
public class CharacterResponse {

  private Long id;
  private String name;
  private String status;
  private String species;
  private String type;
  private String gender;
  private OriginResponse origin;
  private LocationResponse location;
  private String image;
  private List<String> episode;
  private String url;
  private String created;

  @Getter
  @Setter
  @AllArgsConstructor
  @NoArgsConstructor
  public static class OriginResponse {
      private String name;
      private String url;
  }

  @Getter
  @Setter
  @AllArgsConstructor
  @NoArgsConstructor
  public static class LocationResponse {
      private String name;
      private String url;
  }
}
