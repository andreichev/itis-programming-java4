package ru.itis.ideas_api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.ideas_api.dto.IdeaDto;
import ru.itis.ideas_api.exceptions.ValidationException;
import ru.itis.ideas_api.services.IdeasService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/idea")
public class IdeasController {
    private final IdeasService ideasService;

    @PostMapping
    ResponseEntity createIdea(@RequestBody IdeaDto ideaDto) {
        try {
            return ResponseEntity.ok(ideasService.saveIdea(ideaDto));
        } catch (ValidationException e) {
            return ResponseEntity.status(e.getEntity().getStatus()).body(e.getEntity());
        }
    }

    @GetMapping
    List<IdeaDto> getAll() {
        return ideasService.getAll();
    }

    @GetMapping("/{id}")
    IdeaDto getById(@PathVariable Long id) {
        return ideasService.getIdea(id);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id) {
        ideasService.delete(id);
    }
}
