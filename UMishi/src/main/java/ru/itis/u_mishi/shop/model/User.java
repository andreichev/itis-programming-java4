package ru.itis.u_mishi.shop.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "users")
public class User extends AbstractEntity {
    String username;
    @Column(unique = true)
    private String phone;
    private String token;
}
