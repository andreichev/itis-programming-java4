package ru.itis.ideas_api.controller.authorization;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
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
    void checkCode(@RequestParam String phone, @RequestParam String code) {

    }
}
