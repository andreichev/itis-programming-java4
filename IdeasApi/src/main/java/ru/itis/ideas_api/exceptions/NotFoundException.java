package ru.itis.ideas_api.exceptions;

import ru.itis.ideas_api.dto.ErrorDto;

public class NotFoundException extends ValidationException {
    public NotFoundException(ErrorDto errorDto) {
        super(errorDto);
    }

    public NotFoundException(ErrorEntity error) {
        super(error);
    }
}
