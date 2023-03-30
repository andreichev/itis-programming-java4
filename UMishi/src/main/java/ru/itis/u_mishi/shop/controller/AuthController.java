package ru.itis.u_mishi.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.u_mishi.shop.dto.auth.CheckCodeRequest;
import ru.itis.u_mishi.shop.dto.auth.CheckCodeResponse;
import ru.itis.u_mishi.shop.dto.auth.SendSmsRequest;
import ru.itis.u_mishi.shop.dto.auth.SendSmsResponse;
import ru.itis.u_mishi.shop.service.AuthService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/send-sms")
    SendSmsResponse sendSms(@RequestBody SendSmsRequest request) {
        return authService.sendSms(request);
    }

    @PostMapping("/check-code")
    CheckCodeResponse checkCode(@RequestBody CheckCodeRequest request) {
        return authService.checkCode(request);
    }

}
