package ru.itis.spring_app_template.mapper;

import org.springframework.stereotype.Component;
import ru.itis.spring_app_template.dto.PostDto;
import ru.itis.spring_app_template.model.Post;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostMapper {
    public PostDto toPostDto(Post post) {
        return PostDto.builder()
                .text(post.getContent())
                .build();
    }

    public List<PostDto> toPostDtoList(List<Post> list) {
        return list.stream().map(this::toPostDto)
                .collect(Collectors.toList());
    }
}
