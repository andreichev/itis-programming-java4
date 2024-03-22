package ru.itis.car_parking.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itis.car_parking.dto.SignInForm;
import ru.itis.car_parking.dto.SignUpForm;
import ru.itis.car_parking.dto.UserDto;
import ru.itis.car_parking.exceptions.ParkingException;
import ru.itis.car_parking.services.AuthorizationService;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class AuthorizationController {
    private final AuthorizationService authorizationService;

    @RequestMapping(value = "/sign-in", method = RequestMethod.GET)
    String singInPage() {
        return "sign-in";
    }

    @RequestMapping(value = "/sign-up", method = RequestMethod.GET)
    String singUpPage() {
        return "sign-up";
    }

    @RequestMapping(value = "/sign-in", method = RequestMethod.POST)
    String signIn(SignInForm form, HttpSession session, Model model) {
        try {
            UserDto user = authorizationService.signIn(form);
            session.setAttribute("user", user);
        } catch (ParkingException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "sign-in";
        }
        return "redirect:/profile";
    }

    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    String signUp(SignUpForm form, HttpSession session, Model model) {
        UserDto user;
        try {
            user = authorizationService.signUp(form);
        } catch (ParkingException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "sign-up";
        }
        session.setAttribute("user", user);
        return "redirect:/profile";
    }

    @RequestMapping(value = "/sign-out", method = RequestMethod.GET)
    String signOut(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/sign-in";
    }
}
