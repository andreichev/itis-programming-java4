package ru.itis.spring_example.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private String name;
    private int age;
}
