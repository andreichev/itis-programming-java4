package ru.itis.u_mishi.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.u_mishi.shop.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByPhone(String phone);
}
