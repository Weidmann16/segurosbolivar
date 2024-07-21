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
public class LocationCreateRequest {

  @NotBlank(message = "Field name cannot be empty or null.")
  private String name;

  @NotBlank(message = "Field type cannot be empty or null.")
  private String type;

  @NotBlank(message = "Field dimension cannot be empty or null.")
  private String dimension;

  @NotNull(message = "Field residents cannot be null.")
  private String[] residents;

  @NotBlank(message = "Field url cannot be empty or null.")
  private String url;

  @NotBlank(message = "Field created cannot be empty or null.")
  private String created;
}
