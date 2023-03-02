package ru.itis.spring_app_template.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.spring_app_template.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByAgeGreaterThan(int age);
}
