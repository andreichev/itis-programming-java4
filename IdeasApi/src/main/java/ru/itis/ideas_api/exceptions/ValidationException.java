package ru.itis.ideas_api.exceptions;

import lombok.Getter;
import ru.itis.ideas_api.dto.ErrorDto;

import java.util.Collections;

@Getter
public class ValidationException extends RuntimeException {
    private final ErrorDto errorDto;

    public ValidationException(ErrorDto errorDto) {
        this.errorDto = errorDto;
    }

    public ValidationException(ErrorEntity error) {
        this.errorDto = new ErrorDto(Collections.singletonList(error));
    }
}
