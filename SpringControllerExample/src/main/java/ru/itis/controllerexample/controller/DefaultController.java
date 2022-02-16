package ru.itis.controllerexample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DefaultController {
    @GetMapping("/hello")
    @ResponseBody
    String defaultRequest() {
        System.out.println("IT WORKS");
        return "HELLO, WORLD!";
    }

    @GetMapping("/greeting")
    String greeting(Model model) {
        model.addAttribute("message", "HELLO, WORLD!");
        System.out.println("Freemarker checking...");
        return "Greeting";
    }
}
