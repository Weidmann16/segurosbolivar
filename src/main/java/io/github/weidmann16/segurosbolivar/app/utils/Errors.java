package io.github.weidmann16.segurosbolivar.app.utils;

import lombok.Getter;

@Getter
public enum Errors {

  RESULT_NOT_FOUND("ERR_RESULT_001", "Result not found."),
  INVALID_RESULT("ERR_RESULT_002", "Invalid parameters."),
  GENERIC_ERROR("ERR_GEN_001", "An unexpected error occurred.");

  private final String code;
  private final String message;

  Errors(String code, String message) {
    this.code = code;
    this.message = message;
  }

}
