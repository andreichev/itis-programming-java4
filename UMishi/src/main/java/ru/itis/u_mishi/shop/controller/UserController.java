package ru.itis.u_mishi.shop.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.u_mishi.shop.dto.UserDto;
import ru.itis.u_mishi.shop.model.User;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping
    UserDto getProfile() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return UserDto.builder().name(user.getUsername()).build();
    }
}
