package ru.itis.ideas_api.services.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.itis.ideas_api.dto.IdeaDto;
import ru.itis.ideas_api.exceptions.ErrorEntity;
import ru.itis.ideas_api.exceptions.ValidationException;

@Component
public class IdeaDtoValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return IdeaDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        IdeaDto ideaDto = (IdeaDto) target;
        if(ideaDto.getName() == null || ideaDto.getName().isEmpty()) {
            errors.reject("name.empty", new Object[] { ErrorEntity.BLANK_IDEA_NAME }, null);
        }
    }
}
