package com.gabrielrossilopes.fetcher.service;

import com.gabrielrossilopes.fetcher.exception.CharacterNotFoundException;
import com.gabrielrossilopes.fetcher.model.Character;
import com.gabrielrossilopes.fetcher.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    public Character save(Character character) {
        return characterRepository.save(character);
    }

    public List<Character> findAll() {
        return characterRepository.findAll();
    }

    public Page<Character> findAll(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return characterRepository.findAll(pageable);
    }

    public Character findById(Integer id) {
        Optional<Character> characterOptional = characterRepository.findById(id);
        if (characterOptional.isEmpty())
            throw new CharacterNotFoundException("Character of id " + id + " doesn't exist");
        return characterOptional.get();
    }

    public void deleteCharacter(Integer id) {
        Optional<Character> characaterOp = characterRepository.findById(id);
        if (characaterOp.isEmpty()) {
            throw new CharacterNotFoundException("Character of id " + id + " doesn't exist");
        }
        characterRepository.delete(characaterOp.get());
    }

}
