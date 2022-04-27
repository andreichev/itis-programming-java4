package ru.itis.ideas_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.itis.ideas_api.dto.ErrorDto;
import ru.itis.ideas_api.exceptions.NotFoundException;
import ru.itis.ideas_api.exceptions.ValidationException;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler
    public ResponseEntity<ErrorDto> handle(ValidationException ex) {
        return ResponseEntity.status(400).body(ex.getErrorDto());
    }

    @ExceptionHandler
    public ResponseEntity<ErrorDto> handle(NotFoundException ex) {
        return ResponseEntity.status(404).body(ex.getErrorDto());
    }
}
