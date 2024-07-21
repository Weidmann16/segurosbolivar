package io.github.weidmann16.segurosbolivar.app.infrastructure.adapters.input.rest.model.response;

import io.github.weidmann16.segurosbolivar.app.infrastructure.adapters.input.rest.model.response.CharacterResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LocationApiExtResponse {
  private Info info;
  private List<LocationResponse> results;

  @Getter
  @Setter
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Info {
      private Long count;
      private Long pages;
      private String next;
      private String prev;
  }  
}