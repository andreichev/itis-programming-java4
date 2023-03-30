package ru.itis.u_mishi.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.u_mishi.shop.model.OtpCode;

import java.util.Optional;

public interface OtpCodeRepository extends JpaRepository<OtpCode, Integer> {
    Optional<OtpCode> findByPhone(String phone);
}
