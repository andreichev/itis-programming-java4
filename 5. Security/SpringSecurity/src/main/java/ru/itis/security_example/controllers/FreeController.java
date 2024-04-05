package ru.itis.security_example.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FreeController {
    @GetMapping("/free/test")
    String test() {
        return "IT WORKS";
    }
}
