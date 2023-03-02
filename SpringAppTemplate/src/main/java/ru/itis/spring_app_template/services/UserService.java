package ru.itis.spring_app_template.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.spring_app_template.dto.UserDto;
import ru.itis.spring_app_template.mapper.UserMapper;
import ru.itis.spring_app_template.model.User;
import ru.itis.spring_app_template.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserDto> getAllUsers() {
        return userMapper.toUserDtoList(userRepository.findAll());
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
