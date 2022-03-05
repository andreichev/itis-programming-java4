package ru.itis.response_entity_example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    Long id;
    UserDto user;
    String text;
}
