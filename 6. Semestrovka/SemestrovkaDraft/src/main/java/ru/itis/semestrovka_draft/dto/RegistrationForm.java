package ru.itis.semestrovka_draft.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class RegistrationForm {
    @NotBlank
    private String username;
    @NotBlank
    @Length(min = 10)
    private String password;
}
