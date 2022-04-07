package ru.itis.ideas_api.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.ideas_api.exceptions.ErrorEntity;
import ru.itis.ideas_api.exceptions.ValidationException;
import ru.itis.ideas_api.model.OtpPhoneCode;
import ru.itis.ideas_api.model.User;
import ru.itis.ideas_api.repository.OtpPhoneCodesRepository;
import ru.itis.ideas_api.repository.UsersRepository;
import ru.itis.ideas_api.services.UserService;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UsersRepository usersRepository;
    private final OtpPhoneCodesRepository codesRepository;

    @Override
    public void sendOtp(String phone) {
        OtpPhoneCode code = OtpPhoneCode.builder()
                .code("0000")
                .phone(phone)
                .build();
        codesRepository.save(code);
    }

    @Override
    public void checkOtp(String phone, String code) {
        OtpPhoneCode otpPhoneCode = codesRepository.findByPhone(phone)
                .orElseThrow(() -> new ValidationException(ErrorEntity.PHONE_NOT_FOUND));
        if(otpPhoneCode.getCode().equals(code) == false) {
            throw new ValidationException(ErrorEntity.INVALID_OTP);
        }
        codesRepository.delete(otpPhoneCode);
        User user = usersRepository.findByPhone(phone)
                .orElse(User.builder().phone(phone).build());
        user.setToken(UUID.randomUUID().toString());
        usersRepository.save(user);
    }
}
