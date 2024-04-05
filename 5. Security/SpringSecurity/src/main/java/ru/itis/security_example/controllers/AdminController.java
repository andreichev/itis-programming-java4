package ru.itis.security_example.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.security_example.dto.UserDto;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @GetMapping("/user")
    @PreAuthorize("hasRole('ADMIN')")
    UserDto getUser() {
        return UserDto.builder()
                .name("Eldar")
                .age(19)
                .build();
    }
}
