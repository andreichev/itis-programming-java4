package ru.itis.ideas_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.itis.ideas_api.exceptions.ErrorEntity;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ErrorDto {
    private List<ErrorEntity> errors;
}
