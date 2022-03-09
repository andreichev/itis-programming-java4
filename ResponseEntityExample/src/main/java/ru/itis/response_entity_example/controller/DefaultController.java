package ru.itis.response_entity_example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.response_entity_example.dto.CommentDto;
import ru.itis.response_entity_example.dto.UserDto;

@RestController
@RequestMapping("/comment")
public class DefaultController {
    @GetMapping
    CommentDto getComments() {
        return CommentDto.builder()
                .id(1L)
                .user(
                        UserDto.builder()
                                .id(1L)
                                .name("Ivan")
                                .group("11-002")
                                .build()
                )
                .text("TI LOH")
                .build();
    }

    @GetMapping("/{id}")
    ResponseEntity getComment(@PathVariable Long id) {
        if(id == 1) {
            return ResponseEntity.status(500).build();
        }
        return ResponseEntity.ok()
                .header("1", "2")
                .build();
    }
}
