package ru.itis.spring_example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class TestController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    String func() {
        return "HELLO, WORLD!";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    String greeting(Model model) {
        model.addAttribute("message", "IT WORKS");
        return "Greeting";
    }
}
