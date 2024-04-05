package ru.itis.security_example.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {
    @GetMapping("/test")
    String test() {
        return "IT WORKS";
    }
}
