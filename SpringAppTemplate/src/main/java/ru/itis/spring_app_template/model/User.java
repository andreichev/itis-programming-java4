package ru.itis.spring_app_template.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends AbstractEntity {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "password")
    private String hashPassword;
    private String email;
    private Integer age;
    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
    private List<Post> posts;
}
