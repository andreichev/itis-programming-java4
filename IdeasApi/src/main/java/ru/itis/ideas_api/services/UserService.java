package ru.itis.ideas_api.services;

public interface UserService {
    void sendOtp(String phone);
    void checkOtp(String phone, String code);
}
