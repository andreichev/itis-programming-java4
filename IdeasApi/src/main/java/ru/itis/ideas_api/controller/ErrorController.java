package ru.itis.ideas_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.itis.ideas_api.exceptions.ErrorEntity;
import ru.itis.ideas_api.exceptions.ValidationException;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler
    public ResponseEntity<ErrorEntity> handle(ValidationException ex) {
        return ResponseEntity.status(ex.getEntity().getStatus()).body(ex.getEntity());
    }
}
