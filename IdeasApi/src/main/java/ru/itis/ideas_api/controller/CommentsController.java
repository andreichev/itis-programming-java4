package ru.itis.ideas_api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.itis.ideas_api.dto.CommentDto;
import ru.itis.ideas_api.services.CommentsService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/comments")
public class CommentsController {
    private final CommentsService commentsService;

    @PostMapping
    CommentDto createComment(@RequestBody CommentDto commentDto) {
        return commentsService.saveComment(commentDto);
    }

    @GetMapping
    List<CommentDto> getAll() {
        return commentsService.getAll();
    }

    @DeleteMapping
    void delete(Long id) {
        commentsService.delete(id);
    }
}