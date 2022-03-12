package ru.itis.ideas_api.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.ideas_api.dto.IdeaDto;
import ru.itis.ideas_api.model.Idea;
import ru.itis.ideas_api.model.User;
import ru.itis.ideas_api.repository.IdeasRepository;
import ru.itis.ideas_api.repository.UsersRepository;
import ru.itis.ideas_api.services.IdeasService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IdeasServiceImpl implements IdeasService {
    private final UsersRepository usersRepository;
    private final IdeasRepository ideasRepository;

    @Override
    public IdeaDto saveIdea(IdeaDto ideaDto) {
        Optional<User> optionalUser = usersRepository.findById(ideaDto.getAuthorId());
        if(optionalUser.isPresent() == false) {
            // TODO: throw exception
            System.out.println("USER NOT FOUND");
            return null;
        }
        Idea idea = ideaDto.mapToIdea();
        idea.setAuthor(optionalUser.get());
        Idea savedIdea = ideasRepository.save(idea);
        return IdeaDto.getDto(savedIdea);
    }

    @Override
    public IdeaDto getIdea(Long id) {
        Optional<Idea> optionalIdea = ideasRepository.findById(id);
        if(optionalIdea.isPresent() == false) {
            // TODO: throw exception
            return null;
        }
        return IdeaDto.getDto(optionalIdea.get());
    }

    @Override
    public List<IdeaDto> getAll() {
        return ideasRepository.findAll().stream()
                .map(IdeaDto::getDto)
                .collect(Collectors.toList());
    }
}
