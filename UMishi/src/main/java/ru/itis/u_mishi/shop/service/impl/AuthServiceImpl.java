package ru.itis.u_mishi.shop.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.itis.u_mishi.shop.config.security.filter.JwtHelper;
import ru.itis.u_mishi.shop.dto.auth.CheckCodeRequest;
import ru.itis.u_mishi.shop.dto.auth.CheckCodeResponse;
import ru.itis.u_mishi.shop.dto.auth.SendSmsRequest;
import ru.itis.u_mishi.shop.dto.auth.SendSmsResponse;
import ru.itis.u_mishi.shop.exceptions.NotFoundException;
import ru.itis.u_mishi.shop.exceptions.SmsLimitExceededException;
import ru.itis.u_mishi.shop.exceptions.ValidationException;
import ru.itis.u_mishi.shop.mapper.ValidatorMapper;
import ru.itis.u_mishi.shop.model.OtpCode;
import ru.itis.u_mishi.shop.model.User;
import ru.itis.u_mishi.shop.repository.OtpCodeRepository;
import ru.itis.u_mishi.shop.repository.UserRepository;
import ru.itis.u_mishi.shop.service.AuthService;
import ru.itis.u_mishi.shop.service.sms.SmscService;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final SmscService smscService;
    private final OtpCodeRepository codeRepository;
    private final UserRepository userRepository;
    private final JwtHelper jwtHelper;
    private final Validator validator;

    @Override
    public SendSmsResponse sendSms(SendSmsRequest request) {
        Set<ConstraintViolation<SendSmsRequest>> violations = validator.validate(request);
        if (violations.isEmpty() == false) {
            throw new ValidationException(new ValidatorMapper<SendSmsRequest>().getMessage(violations));
        }
        if (codeRepository.countOtpCodesByPhone(request.getPhone()) > 3) {
            throw new SmsLimitExceededException("The limit of sent SMS has been exceeded");
        }
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
        User user = userRepository.findByPhone(request.getPhone())
                .orElse(User.builder().phone(request.getPhone()).build());
        userRepository.save(user);
        String token = jwtHelper.generateToken(user);
        return CheckCodeResponse.builder().token(token).build();
    }

    @Scheduled(cron = "0 0 6 * * ?")
    public void cleanerCodes(){
        codeRepository.deleteOtpCodeByCreatedAtBefore(Instant.now()
                .minus(5, ChronoUnit.MINUTES)
        );
    }
}
