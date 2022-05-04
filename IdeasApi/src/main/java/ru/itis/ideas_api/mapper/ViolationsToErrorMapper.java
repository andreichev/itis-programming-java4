package ru.itis.ideas_api.mapper;

import ru.itis.ideas_api.dto.ErrorDto;
import ru.itis.ideas_api.exceptions.ErrorEntity;

import javax.validation.ConstraintViolation;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class ViolationsToErrorMapper {
    public static ErrorDto toDto(Object[] violations) {
        return new ErrorDto(Arrays.stream(violations)
                .map(item -> ErrorEntity.valueOf(((ConstraintViolation<?>) item).getMessage()))
                .collect(Collectors.toList()));
    }

    public static ErrorDto toDto(Set<ConstraintViolation<?>> violations) {
        return new ErrorDto(violations.stream()
                .map(item -> ErrorEntity.valueOf(item.getMessage()))
                .collect(Collectors.toList()));
    }
}
