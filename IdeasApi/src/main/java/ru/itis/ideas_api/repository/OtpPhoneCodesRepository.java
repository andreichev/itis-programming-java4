package ru.itis.ideas_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.ideas_api.model.OtpPhoneCode;

import java.util.Optional;

public interface OtpPhoneCodesRepository extends JpaRepository<OtpPhoneCode, Long> {
    Optional<OtpPhoneCode> findByPhone(String phone);
}
