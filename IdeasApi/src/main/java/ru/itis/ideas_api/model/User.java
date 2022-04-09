package ru.itis.ideas_api.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends AbstractEntity implements Serializable {
    @Column(name = "user_name")
    private String name;
    @Column(unique = true)
    private String phone;
    private String token;
}
