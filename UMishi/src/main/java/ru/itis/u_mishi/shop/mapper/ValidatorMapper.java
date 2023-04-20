package ru.itis.u_mishi.shop.mapper;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class ValidatorMapper<T> {
    public String getMessage(Set<ConstraintViolation<T>> violations) {
        StringBuilder message = new StringBuilder();
        for (ConstraintViolation<T> violation : violations) {
            message.append(violation.getMessage());
        }
        return message.toString();
    }
}
