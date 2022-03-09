package ru.itis.spring_app_template.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.spring_app_template.model.User;
import ru.itis.spring_app_template.services.UserService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/test")
public class DefaultController {
    private final UserService userService;

    @GetMapping
    String test() {
        userService.save(User.builder().firstName("Ivan").lastName("Ivanov").build());
        return "OK";
    }

    @GetMapping("/users")
    List<User> getAll() {
        return userService.getAllUsers();
    }
}
