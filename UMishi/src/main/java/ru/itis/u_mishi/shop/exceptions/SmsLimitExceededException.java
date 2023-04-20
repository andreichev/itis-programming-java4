package ru.itis.u_mishi.shop.exceptions;

public class SmsLimitExceededException extends RuntimeException {
    public SmsLimitExceededException(String message){ super(message); }
}
