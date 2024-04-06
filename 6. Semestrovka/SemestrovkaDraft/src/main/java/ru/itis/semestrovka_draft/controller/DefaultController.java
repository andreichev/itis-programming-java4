package ru.itis.semestrovka_draft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {
    @GetMapping("/test")
    String test() {
        return "test_view";
    }
}
