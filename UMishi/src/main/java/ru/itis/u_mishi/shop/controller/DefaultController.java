package ru.itis.u_mishi.shop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

    @GetMapping("/test")
    String getStatus() {
        return "OK";
    }
}
