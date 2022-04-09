package ru.itis.ideas_api.controller.authorization;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.ideas_api.services.UserService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthorizationController {
    private final UserService userService;

    @PostMapping("/send-otp")
    void sendOtp(@RequestParam String phone) {
        userService.sendOtp(phone);
    }

    @PostMapping("/check-code")
    String checkCode(@RequestParam String phone, @RequestParam String code) {
        return userService.checkOtp(phone, code);
    }
}
