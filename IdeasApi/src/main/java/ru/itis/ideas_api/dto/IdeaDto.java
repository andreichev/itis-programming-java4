package ru.itis.ideas_api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IdeaDto {
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    private Integer likesCount;
    private UserDto author;
    @NotNull
    private Long authorId;
    private List<CommentDto> comments;
}
