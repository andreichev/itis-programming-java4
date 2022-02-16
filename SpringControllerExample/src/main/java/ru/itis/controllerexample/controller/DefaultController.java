package ru.itis.controllerexample.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DefaultController {

    // Следующая запись идентична этой записи
    // @GetMapping("/hello")
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
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

    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    String getStudent() {
        return "{ \"name\": \"Ivan Ivanov\", \"university\": \"KPFU\" }";
    }
}
