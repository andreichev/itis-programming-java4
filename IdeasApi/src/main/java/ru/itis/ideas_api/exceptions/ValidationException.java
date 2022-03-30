package ru.itis.ideas_api.exceptions;

import lombok.Getter;

@Getter
public class ValidationException extends RuntimeException {
    private final ErrorEntity entity;

    public ValidationException(ErrorEntity entity) {
        super(entity.getMessage());
        this.entity = entity;
    }

    public ValidationException(ErrorEntity entity, String message) {
        super(message);
        this.entity = entity;
    }
}
