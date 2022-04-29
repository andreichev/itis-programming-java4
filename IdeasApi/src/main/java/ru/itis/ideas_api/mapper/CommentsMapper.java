package ru.itis.ideas_api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itis.ideas_api.dto.CommentDto;
import ru.itis.ideas_api.model.Comment;

@Mapper(uses = {UserMapper.class, IdeasMapper.class})
public interface CommentsMapper {

    @Mapping(target = "idea", ignore = true)
    CommentDto getDto(Comment comment);

    @Mapping(target = "idea", ignore = true)
    Comment getComment(CommentDto commentDto);
}
