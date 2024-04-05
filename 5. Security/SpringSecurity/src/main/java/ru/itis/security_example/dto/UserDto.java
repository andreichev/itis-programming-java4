package ru.itis.security_example.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    String name;
    int age;
}
