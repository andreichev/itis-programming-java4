package ru.itis.u_mishi.shop.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.u_mishi.shop.dto.auth.CheckCodeRequest;
import ru.itis.u_mishi.shop.dto.auth.CheckCodeResponse;
import ru.itis.u_mishi.shop.dto.auth.SendSmsRequest;
import ru.itis.u_mishi.shop.dto.auth.SendSmsResponse;
import ru.itis.u_mishi.shop.model.OtpCode;
import ru.itis.u_mishi.shop.repository.OtpCodeRepository;
import ru.itis.u_mishi.shop.service.AuthService;
import ru.itis.u_mishi.shop.service.sms.SmscService;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final SmscService smscService;
    private final OtpCodeRepository codeRepository;

    @Override
    public SendSmsResponse sendSms(SendSmsRequest request) {
        String code = String.valueOf((int)(Math.random() * 10)) +
                (int) (Math.random() * 10) +
                (int) (Math.random() * 10) +
                (int) (Math.random() * 10);
        smscService.sendSms(request.getPhone(), code);
        codeRepository.save(OtpCode.builder().phone(request.getPhone()).code(code).build());
        return new SendSmsResponse("OK");
    }

    @Override
    public CheckCodeResponse checkCode(CheckCodeRequest request) {

        return null;
    }
}
