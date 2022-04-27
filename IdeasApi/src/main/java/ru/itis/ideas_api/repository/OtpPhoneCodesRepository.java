package ru.itis.ideas_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.itis.ideas_api.model.OtpPhoneCode;

import java.time.Instant;
import java.util.Optional;

public interface OtpPhoneCodesRepository extends JpaRepository<OtpPhoneCode, Long> {
    Optional<OtpPhoneCode> findByPhone(String phone);
    @Modifying
    @Query("delete from OtpPhoneCode where updatedAt < :time")
    void deleteByUpdatedAtBefore(@Param("time") Instant time);
}
