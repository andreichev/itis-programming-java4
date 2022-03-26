package ru.itis.ideas_api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itis.ideas_api.dto.IdeaDto;
import ru.itis.ideas_api.model.Idea;

@Mapper(uses = {UserMapper.class})
public interface IdeasMapper {
    @Mapping(target = "comments", ignore = true)
    IdeaDto getDto(Idea idea);
    @Mapping(target = "comments", ignore = true)
    Idea getIdea(IdeaDto ideaDto);
}
