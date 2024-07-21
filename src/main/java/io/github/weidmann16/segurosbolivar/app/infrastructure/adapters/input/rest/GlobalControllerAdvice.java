package io.github.weidmann16.segurosbolivar.app.infrastructure.adapters.input.rest;

import io.github.weidmann16.segurosbolivar.app.domain.exception.ApiNotFoundException;
import io.github.weidmann16.segurosbolivar.app.domain.model.ErrorResponse;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.stream.Collectors;

import static io.github.weidmann16.segurosbolivar.app.utils.Errors.GENERIC_ERROR;
import static io.github.weidmann16.segurosbolivar.app.utils.Errors.INVALID_RESULT;
import static io.github.weidmann16.segurosbolivar.app.utils.Errors.RESULT_NOT_FOUND;

@RestControllerAdvice
public class GlobalControllerAdvice {

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(ApiNotFoundException.class)
  public ErrorResponse handleApiNotFoundException() {
    return ErrorResponse.builder()
        .code(RESULT_NOT_FOUND.getCode())
        .message(RESULT_NOT_FOUND.getMessage())
        .timestamp(LocalDateTime.now())
        .build();
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ErrorResponse handleMethodArgumentNotValidException(
      MethodArgumentNotValidException exception) {
    BindingResult result = exception.getBindingResult();

    return ErrorResponse.builder()
        .code(INVALID_RESULT.getCode())
        .message(INVALID_RESULT.getMessage())
        .details(result.getFieldErrors()
            .stream()
            .map(DefaultMessageSourceResolvable::getDefaultMessage)
            .collect(Collectors.toList()))
        .timestamp(LocalDateTime.now())
        .build();
  }

  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(Exception.class)
  public ErrorResponse handleGenericError(Exception exception) {
    return ErrorResponse.builder()
        .code(GENERIC_ERROR.getCode())
        .message(GENERIC_ERROR.getMessage())
        .details(Collections.singletonList(exception.getMessage()))
        .timestamp(LocalDateTime.now())
        .build();
  }

}
