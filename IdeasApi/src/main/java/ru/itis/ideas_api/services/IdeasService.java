package ru.itis.ideas_api.services;

import ru.itis.ideas_api.dto.IdeaDto;

import java.util.List;

public interface IdeasService {
    IdeaDto saveIdea(IdeaDto ideaDto);
    IdeaDto getIdea(Long id);
    List<IdeaDto> getAll();
    void delete(Long id);
}
