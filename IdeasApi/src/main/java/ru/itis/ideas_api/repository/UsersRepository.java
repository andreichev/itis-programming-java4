package ru.itis.ideas_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.ideas_api.model.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findByPhone(String phone);

    Optional<User> findByToken(String token);
}
