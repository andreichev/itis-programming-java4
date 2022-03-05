package ru.itis.response_entity_example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.response_entity_example.dto.CommentDto;
import ru.itis.response_entity_example.dto.UserDto;

@RestController
public class DefaultController {

    @PostMapping(value = "/comment")
    ResponseEntity getComment() {
        if (Math.random() > 0.5) {
            return ResponseEntity.ok(CommentDto.builder()
                    .id(1L)
                    .user(
                            UserDto.builder()
                                    .id(1L)
                                    .name("Ivan")
                                    .group("11-005")
                                    .build()
                    )
                    .text("TI LOH")
                    .build());
        }
        return ResponseEntity.status(500).build();
    }
}
