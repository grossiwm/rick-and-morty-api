package com.gabrielrossilopes.fetcher.converter;

import com.gabrielrossilopes.fetcher.client.dto.CharacterDto;
import com.gabrielrossilopes.fetcher.model.Character;

public class CharacterDtoToCharacterConverter {
    public static Character convert(CharacterDto dto) {
        Character character = new Character();
        character.setName(dto.getName());
        character.setGender(dto.getGender());
        character.setStatus(dto.getStatus());
        character.setSpecies(dto.getSpecies());

        return character;
    }
}
