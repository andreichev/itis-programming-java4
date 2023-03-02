package ru.itis.spring_app_template.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.itis.spring_app_template.dto.UserDto;
import ru.itis.spring_app_template.model.User;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserMapper {
    private final PostMapper postMapper;

    public UserDto toUserDto(User user) {
        return UserDto.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .posts(postMapper.toPostDtoList(user.getPosts()))
                .build();
    }

    public List<UserDto> toUserDtoList(List<User> list) {
        return list.stream().map(this::toUserDto)
                .collect(Collectors.toList());
    }
}
