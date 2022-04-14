package ru.itis.ideas_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import ru.itis.ideas_api.model.OtpPhoneCode;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface OtpPhoneCodesRepository extends JpaRepository<OtpPhoneCode, Long> {
    Optional<OtpPhoneCode> findByPhone(String phone);
    List<OtpPhoneCode> findAllByUpdatedAtBefore(Instant time);
}
