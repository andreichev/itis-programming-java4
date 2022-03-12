package ru.itis.ideas_api.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "user_id")
    User author;
    String text;
    @ManyToOne
    @JoinColumn(name = "idea_id")
    Idea idea;
}
