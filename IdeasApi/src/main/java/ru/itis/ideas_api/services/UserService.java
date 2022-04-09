package ru.itis.ideas_api.services;

public interface UserService {
    void sendOtp(String phone);

    String checkOtp(String phone, String code);
}
