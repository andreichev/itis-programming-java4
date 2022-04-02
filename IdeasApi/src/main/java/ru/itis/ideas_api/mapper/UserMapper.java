package ru.itis.ideas_api.mapper;

import org.mapstruct.Mapper;
import ru.itis.ideas_api.dto.UserDto;
import ru.itis.ideas_api.model.User;

@Mapper
public interface UserMapper {
    UserDto getDto(User user);
    User getUser(UserDto userDto);
}
