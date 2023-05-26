package ru.itis.ideas_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.ideas_api.model.Comment;

public interface CommentsRepository extends JpaRepository<Comment, Long> {
}