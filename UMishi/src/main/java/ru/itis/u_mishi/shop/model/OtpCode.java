package ru.itis.u_mishi.shop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "otp_code")
public class OtpCode extends AbstractEntity {
    @Column(unique = true)
    String phone;
    String code;
}
