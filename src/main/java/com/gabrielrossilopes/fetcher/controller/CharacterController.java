package com.gabrielrossilopes.fetcher.controller;

import com.gabrielrossilopes.fetcher.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}
