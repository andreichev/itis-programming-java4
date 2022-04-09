package ru.itis.ideas_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.ideas_api.model.Idea;

public interface IdeasRepository extends JpaRepository<Idea, Long> {
}
