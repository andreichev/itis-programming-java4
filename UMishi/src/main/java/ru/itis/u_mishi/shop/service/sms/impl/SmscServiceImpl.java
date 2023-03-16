package ru.itis.u_mishi.shop.service.sms.impl;

import org.springframework.stereotype.Service;
import ru.itis.u_mishi.shop.service.sms.SmscService;

@Service
public class SmscServiceImpl implements SmscService  {
    @Override
    public void sendSms(String phone, String message) {
        System.out.println("SMS " + message + " SENT SMS CODE TO " + phone);
    }


}
