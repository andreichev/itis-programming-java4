package ru.itis.semestrovka_draft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizationController {
    @GetMapping("/sign-in")
    String signInView(@RequestParam(required = false) String error, Model model) {
        model.addAttribute("error", error);
        return "sign_in_view";
    }
}
