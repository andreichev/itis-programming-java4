package ru.itis.semestrovka_draft.controller.handlers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.itis.semestrovka_draft.dto.ErrorValidInfo;
import ru.itis.semestrovka_draft.dto.ValidError;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class ErrorsController {
    @ExceptionHandler(BindException.class)
    public ResponseEntity<ErrorValidInfo> handleBindException(BindException e, HttpServletRequest request) {
        log.warn(String.format("Got validation exception %s from URL %s", e.getMessage(), request.getRequestURI()));
        var dtoValidationError = ErrorValidInfo.builder()
                .code(HttpStatus.BAD_REQUEST)
                .message("Validation error")
                .validErrors(processFieldErrors(e.getBindingResult()))
                .path(request.getRequestURI())
                .exceptionName(e.getClass().getSimpleName())
                .build();
        return new ResponseEntity<>(dtoValidationError, dtoValidationError.getCode());
    }

    private List<ValidError> processFieldErrors(BindingResult bindingResult) {
        return bindingResult.getAllErrors().stream()
                .map(e -> {
                    if (e instanceof FieldError error) {
                        return new ValidError(error.getField(), error.getDefaultMessage());
                    }
                    return new ValidError(e.getObjectName(), e.getDefaultMessage());
                })
                .collect(Collectors.toList());
    }
}
