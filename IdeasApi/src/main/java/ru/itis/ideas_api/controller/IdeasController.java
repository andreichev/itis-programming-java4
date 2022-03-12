package ru.itis.ideas_api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.itis.ideas_api.dto.IdeaDto;
import ru.itis.ideas_api.services.IdeasService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/idea")
public class IdeasController {
    private final IdeasService ideasService;

    @PostMapping
    IdeaDto createIdea(@RequestBody IdeaDto ideaDto) {
        return ideasService.saveIdea(ideaDto);
    }

    @GetMapping
    List<IdeaDto> getAll() {
        return ideasService.getAll();
    }

    @GetMapping("/{id}")
    IdeaDto getById(@PathVariable Long id) {
        return ideasService.getIdea(id);
    }
}
