package ru.itis.u_mishi.shop.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.u_mishi.shop.dto.auth.CheckCodeRequest;
import ru.itis.u_mishi.shop.dto.auth.CheckCodeResponse;
import ru.itis.u_mishi.shop.dto.auth.SendSmsRequest;
import ru.itis.u_mishi.shop.dto.auth.SendSmsResponse;
import ru.itis.u_mishi.shop.exceptions.NotFoundException;
import ru.itis.u_mishi.shop.exceptions.ValidationException;
import ru.itis.u_mishi.shop.model.OtpCode;
import ru.itis.u_mishi.shop.model.User;
import ru.itis.u_mishi.shop.repository.OtpCodeRepository;
import ru.itis.u_mishi.shop.repository.UserRepository;
import ru.itis.u_mishi.shop.service.AuthService;
import ru.itis.u_mishi.shop.service.sms.SmscService;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final SmscService smscService;
    private final OtpCodeRepository codeRepository;
    private final UserRepository userRepository;

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
        Optional<OtpCode> optionalOtpCode = codeRepository.findByPhone(request.getPhone());
        if (optionalOtpCode.isEmpty()) {
            throw new NotFoundException("Sms is not sent");
        }
        OtpCode otpCode = optionalOtpCode.get();
        if (!otpCode.getCode().equals(request.getCode())) {
            throw new ValidationException("Wrong code");
        }
        String token = UUID.randomUUID().toString();
        User user = userRepository.findByPhone(request.getPhone())
                .orElse(User.builder().phone(request.getPhone()).build());
        user.setToken(token);
        userRepository.save(user);
        return CheckCodeResponse.builder().token(token).build();
    }
}
