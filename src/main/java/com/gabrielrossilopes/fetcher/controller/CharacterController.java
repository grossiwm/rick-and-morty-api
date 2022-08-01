package com.gabrielrossilopes.fetcher.controller;

import com.gabrielrossilopes.fetcher.model.Character;
import com.gabrielrossilopes.fetcher.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/character")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping
    public ResponseEntity<?> getAllCharacters(
        @RequestParam(required = false, defaultValue = "5") Integer pageSize,
        @RequestParam(required = false, defaultValue = "0") Integer pageNumber
    ) {

        return ResponseEntity.ok(characterService.findAll(pageNumber, pageSize));
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> findCharacter(@PathVariable Integer id) {
        return ResponseEntity.ok(characterService.findById(id));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> removeCharacter(@PathVariable Integer id) {
        characterService.deleteCharacter(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    private ResponseEntity<?> createCharacter(@RequestBody Character character) {
        characterService.save(character);
        return ResponseEntity.created(URI.create("/character/" + character.getId())).build();
    }
}
