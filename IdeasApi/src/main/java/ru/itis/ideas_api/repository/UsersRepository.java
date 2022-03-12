package ru.itis.ideas_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.ideas_api.model.User;

public interface UsersRepository extends JpaRepository<User, Long> {}
