package ru.itis.ideas_api.services;

import ru.itis.ideas_api.dto.CommentDto;
import java.util.List;

public interface CommentsService {
    CommentDto saveComment(CommentDto commentDto);
    CommentDto getComment(Long id);
    List<CommentDto> getAll();
    void delete(Long id);
}