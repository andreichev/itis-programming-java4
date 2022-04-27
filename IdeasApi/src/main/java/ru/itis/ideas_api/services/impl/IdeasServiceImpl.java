package ru.itis.ideas_api.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.itis.ideas_api.dto.IdeaDto;
import ru.itis.ideas_api.exceptions.ErrorEntity;
import ru.itis.ideas_api.exceptions.NotFoundException;
import ru.itis.ideas_api.exceptions.ValidationException;
import ru.itis.ideas_api.mapper.IdeasMapper;
import ru.itis.ideas_api.mapper.ViolationsToErrorMapper;
import ru.itis.ideas_api.model.Idea;
import ru.itis.ideas_api.model.User;
import ru.itis.ideas_api.repository.IdeasRepository;
import ru.itis.ideas_api.repository.UsersRepository;
import ru.itis.ideas_api.services.IdeasService;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IdeasServiceImpl implements IdeasService {
    private final IdeasRepository ideasRepository;
    private final IdeasMapper ideasMapper;
    private final Validator validator;

    @Override
    public IdeaDto saveIdea(IdeaDto ideaDto) {
        Set<ConstraintViolation<IdeaDto>> violations = validator.validate(ideaDto);
        if (violations.isEmpty() == false) {
            throw new ValidationException(ViolationsToErrorMapper.toDto(violations.toArray()));
        }
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Idea idea = ideasMapper.getIdea(ideaDto);
        idea.setAuthor(user);
        Idea savedIdea = ideasRepository.save(idea);
        return ideasMapper.getDto(savedIdea);
    }

    @Override
    public IdeaDto getIdea(Long id) {
        Optional<Idea> optionalIdea = ideasRepository.findById(id);
        if (optionalIdea.isPresent() == false) {
            throw new NotFoundException(ErrorEntity.IDEA_NOT_FOUND);
        }
        return ideasMapper.getDto(optionalIdea.get());
    }

    @Override
    public List<IdeaDto> getAll() {
        return ideasRepository.findAll().stream()
                .map(ideasMapper::getDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        ideasRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorEntity.IDEA_NOT_FOUND));
        ideasRepository.deleteById(id);
    }
}
