package ru.itis.ideas_api.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.ideas_api.dto.CommentDto;
import ru.itis.ideas_api.exceptions.ErrorEntity;
import ru.itis.ideas_api.exceptions.ValidationException;
import ru.itis.ideas_api.mapper.CommentsMapper;
import ru.itis.ideas_api.model.Comment;
import ru.itis.ideas_api.model.Idea;
import ru.itis.ideas_api.model.User;
import ru.itis.ideas_api.repository.CommentsRepository;
import ru.itis.ideas_api.repository.IdeasRepository;
import ru.itis.ideas_api.repository.UsersRepository;
import ru.itis.ideas_api.services.CommentsService;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentsServiceImpl implements CommentsService {
    private final UsersRepository usersRepository;
    private final CommentsRepository commentsRepository;
    private final IdeasRepository ideasRepository;
    private final CommentsMapper commentsMapper;
    private final Validator validator;

    @Override
    public CommentDto saveComment(CommentDto commentDto) {
        Set<ConstraintViolation<CommentDto>> violations = validator.validate(commentDto);
        if (violations.isEmpty() == false) {
            throw new ValidationException(violations.stream().findFirst().get().getMessage());
        }

        Optional<User> optionalUser = usersRepository.findById(commentDto.getAuthorId());
        if (optionalUser.isPresent() == false) {
            throw new ValidationException(ErrorEntity.USER_NOT_FOUND);
        }

        Optional<Idea> optionalIdea = ideasRepository.findById(commentDto.getIdea().getId());
        if (optionalIdea.isPresent() == false) {
            throw new ValidationException(ErrorEntity.USER_NOT_FOUND);
        }

        Comment comment = commentsMapper.getComment(commentDto);
        comment.setAuthor(optionalUser.get());
        comment.setIdea(optionalIdea.get());
        Comment savedComment = commentsRepository.save(comment);
        return commentsMapper.getDto(savedComment);
    }

    @Override
    public CommentDto getComment(Long id) {
        Optional<Comment> optionalComment = commentsRepository.findById(id);
        if (optionalComment.isPresent() == false) {
            throw new ValidationException(ErrorEntity.IDEA_NOT_FOUND);
        }
        return commentsMapper.getDto(optionalComment.get());
    }

    @Override
    public List<CommentDto> getAll() {
        return commentsRepository.findAll().stream()
                .map(commentsMapper::getDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        commentsRepository.findById(id)
                .orElseThrow(() -> new ValidationException(ErrorEntity.IDEA_NOT_FOUND));
        commentsRepository.deleteById(id);
    }
}