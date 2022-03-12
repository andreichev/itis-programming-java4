package ru.itis.ideas_api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.ideas_api.model.Idea;

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

    public Idea mapToIdea() {
        Idea idea = Idea.builder()
                .name(name)
                .description(description)
                .likesCount(likesCount)
                .build();
        idea.setId(id);
        return idea;
    }

    public static IdeaDto getDto(Idea idea) {
        return IdeaDto.builder()
                .id(idea.getId())
                .name(idea.getName())
                .description(idea.getDescription())
                .likesCount(idea.getLikesCount())
                .build();
    }
}
