package ru.itis.u_mishi.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.u_mishi.shop.model.OtpCode;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.Optional;

public interface OtpCodeRepository extends JpaRepository<OtpCode, Integer> {
    Optional<OtpCode> findByPhone(String phone);
    @Transactional
    void deleteOtpCodeByCreatedAtBefore(Instant createdAt);
    Long countOtpCodesByPhone(String phone);
}
