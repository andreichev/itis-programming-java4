package ru.itis.ideas_api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDto {
    UserDto author;
    @NotBlank(message = "BLANK_COMMENT_TEXT")
    String text;
    IdeaDto idea;
    @NotNull(message = "USER_ID_EMPTY")
    private Long authorId;
}
