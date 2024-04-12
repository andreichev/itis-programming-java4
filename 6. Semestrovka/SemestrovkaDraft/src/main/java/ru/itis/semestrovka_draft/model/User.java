package ru.itis.semestrovka_draft.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_account")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {

    @Column(name = "username", nullable = false, unique = true)
    String username;

    @Column(name = "password", nullable = false)
    String passwordHash;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;
}
