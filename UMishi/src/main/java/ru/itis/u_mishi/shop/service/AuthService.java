package ru.itis.u_mishi.shop.service;

import ru.itis.u_mishi.shop.dto.auth.CheckCodeRequest;
import ru.itis.u_mishi.shop.dto.auth.CheckCodeResponse;
import ru.itis.u_mishi.shop.dto.auth.SendSmsRequest;
import ru.itis.u_mishi.shop.dto.auth.SendSmsResponse;

public interface AuthService {
    SendSmsResponse sendSms(SendSmsRequest request);
    CheckCodeResponse checkCode(CheckCodeRequest request);
}
