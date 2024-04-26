package ru.itis.semestrovka_draft.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ErrorValidInfo {

    private String message;

    private HttpStatus code;

    private String path;

    private String exceptionName;

    private List<ValidError> validErrors;

}
