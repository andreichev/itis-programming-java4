package ru.itis.car_parking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itis.car_parking.dto.UserDto;

import javax.servlet.http.HttpSession;

@Controller
public class ProfileController {
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    String getMyProfile(Model model, HttpSession session) {
        UserDto user = (UserDto) session.getAttribute("user");
        model.addAttribute("user", user);
        return "profile";
    }
}
