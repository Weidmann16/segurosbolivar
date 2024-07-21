package io.github.weidmann16.segurosbolivar.app.infrastructure.adapters.input.rest.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class CharacterCreateRequest {

  @NotBlank(message = "Field name cannot be empty or null.")
  private String name;

  @NotBlank(message = "Field status cannot be empty or null.")
  private String status;

  @NotBlank(message = "Field species cannot be empty or null.")
  private String species;

  @NotBlank(message = "Field type cannot be empty or null.")
  private String type;

  @NotBlank(message = "Field gender cannot be empty or null.")
  private String gender;

  @NotNull(message = "Field origin cannot be null.")
  private OriginRequest origin;

  @NotNull(message = "Field location cannot be null.")
  private LocationRequest location;

  @NotBlank(message = "Field image cannot be empty or null.")
  private String image;

  @NotNull(message = "Field episode cannot be null.")
  private String[] episode;

  @NotBlank(message = "Field url cannot be empty or null.")
  private String url;

  @NotBlank(message = "Field created cannot be empty or null.")
  private String created;

  @Getter
  @Setter
  @AllArgsConstructor
  @NoArgsConstructor
  public static class OriginRequest {
      @NotBlank(message = "Field name cannot be empty or null.")
      private String name;

      @NotBlank(message = "Field url cannot be empty or null.")
      private String url;
  }

  @Getter
  @Setter
  @AllArgsConstructor
  @NoArgsConstructor
  public static class LocationRequest {
      @NotBlank(message = "Field name cannot be empty or null.")
      private String name;

      @NotBlank(message = "Field url cannot be empty or null.")
      private String url;
  }
}
