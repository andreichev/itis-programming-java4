package ru.itis.ideas_api.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.itis.ideas_api.exceptions.ErrorEntity;
import ru.itis.ideas_api.exceptions.NotFoundException;
import ru.itis.ideas_api.exceptions.ValidationException;
import ru.itis.ideas_api.model.OtpPhoneCode;
import ru.itis.ideas_api.model.User;
import ru.itis.ideas_api.repository.OtpPhoneCodesRepository;
import ru.itis.ideas_api.repository.UsersRepository;
import ru.itis.ideas_api.services.UserService;

import java.time.Instant;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UsersRepository usersRepository;
    private final OtpPhoneCodesRepository codesRepository;

    @Override
    public void sendOtp(String phone) {
        String newCode = String.valueOf(System.currentTimeMillis() % 10000);
        OtpPhoneCode code = codesRepository.findByPhone(phone)
                .orElse(
                        OtpPhoneCode.builder()
                                .phone(phone)
                                .build()
                );
        code.setCode(newCode);
        if(code.getUpdatedAt() != null &&
           code.getUpdatedAt().plusSeconds(10).compareTo(Instant.now()) >= 0) {
            throw new ValidationException(ErrorEntity.TOO_OFTEN_OTP);
        }
        codesRepository.save(code);
    }

    @Override
    public String checkOtp(String phone, String code) {
        OtpPhoneCode otpPhoneCode = codesRepository.findByPhone(phone)
                .orElseThrow(() -> new NotFoundException(ErrorEntity.PHONE_NOT_FOUND));
        if (otpPhoneCode.getCode().equals(code) == false) {
            throw new ValidationException(ErrorEntity.INVALID_OTP);
        }
        codesRepository.delete(otpPhoneCode);
        User user = usersRepository.findByPhone(phone)
                .orElse(User.builder().phone(phone).build());
        String token = UUID.randomUUID().toString();
        user.setToken(token);
        usersRepository.save(user);
        return token;
    }

    @Scheduled(fixedRate = 20000)
    @Override
    public void deleteOldCodes() {
        codesRepository.deleteByUpdatedAtBefore(
                Instant.now().minusSeconds(5)
        );
    }
}
