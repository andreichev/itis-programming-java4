package ru.itis.u_mishi.shop.service.sms;

public interface SmscService {
    void sendSms(String phone, String message);
}
