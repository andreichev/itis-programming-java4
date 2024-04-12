package ru.itis.semestrovka_draft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.semestrovka_draft.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UsersRepository extends JpaRepository<User, UUID> {
    boolean existsByUsername(String username);
    Optional<User> findByUsername(String username);
}
