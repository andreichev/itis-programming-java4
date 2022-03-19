package ru.itis.ideas_api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IdeaDto {
    private Long id;
    private String name;
    private String description;
    private Integer likesCount;
    private UserDto author;
    private Long authorId;
    private List<CommentDto> comments;
}
