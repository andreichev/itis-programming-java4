package ru.itis.u_mishi.shop.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "otp_code")
public class OtpCode extends AbstractEntity {
    @Column(unique = true)
    private String phone;
    private String code;
}
