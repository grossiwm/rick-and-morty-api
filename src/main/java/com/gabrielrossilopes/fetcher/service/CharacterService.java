package com.gabrielrossilopes.fetcher.service;

import com.gabrielrossilopes.fetcher.model.Character;
import com.gabrielrossilopes.fetcher.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    public void save(Character character) {
        characterRepository.save(character);
    }

    public List<Character> findAll() {
        return characterRepository.findAll();
    }

    public Page<Character> findAll(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return characterRepository.findAll(pageable);
    }
}
