package ru.itis.semestrovka_draft.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class RegistrationForm {
    private String username;
    private String password;
}
