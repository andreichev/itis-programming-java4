package ru.itis.ideas_api.dto.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String> {
    @Override
    public void initialize(Phone constraintAnnotation) {}

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        s = s.replaceAll("[\\s()-]", "");
        return s.length() == 11 && s.startsWith("8") && s.matches("[0-9]+");
    }
}