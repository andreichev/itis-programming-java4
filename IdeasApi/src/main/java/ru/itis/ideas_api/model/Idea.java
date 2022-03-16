package ru.itis.ideas_api.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Idea extends AbstractEntity {
    String name;
    String description;
    @Column(name = "likes_count", nullable = false)
    Integer likesCount;
    @ManyToOne
    @JoinColumn(name = "user_id")
    User author;
    @OneToMany(mappedBy = "idea")
    List<Comment> comments;
}
