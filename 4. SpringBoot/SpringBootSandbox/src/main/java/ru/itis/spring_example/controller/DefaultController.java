package ru.itis.spring_example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.spring_example.model.User;

@RestController
public class DefaultController {
    @GetMapping(value = "/test")
    User test() {
        return User.builder()
                .name("Alexey")
                .age(20)
                .build();
    }
}
