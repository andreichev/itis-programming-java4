package ru.itis.u_mishi.shop.controller;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import ru.itis.u_mishi.shop.dto.ErrorInfo;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@RestControllerAdvice
public class ErrorController {
    @ExceptionHandler(value = HttpClientErrorException.class)
    public ResponseEntity<Object> handleBadRequestException(HttpClientErrorException e, HttpServletRequest request) {
        return new ResponseEntity<>(
                ErrorInfo.builder()
                        .timestamp(Instant.now())
                        .error(e.getMessage())
                        .status(400)
                        .exceptionName(e.getClass().getSimpleName())
                        .path(request.getRequestURI())
                        .build(),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = JacksonException.class)
    public ResponseEntity<Object> handleSpException(JacksonException e, HttpServletRequest request) {
        return new ResponseEntity<>(
                ErrorInfo.builder()
                        .timestamp(Instant.now())
                        .error(e.getMessage())
                        .status(400)
                        .exceptionName(e.getClass().getSimpleName())
                        .path(request.getRequestURI())
                        .build(),
                HttpStatus.BAD_REQUEST
        );
    }
}
