package com.gabrielrossilopes.fetcher.runner;

import com.gabrielrossilopes.fetcher.client.RickAndMortyApiClient;
import com.gabrielrossilopes.fetcher.client.dto.CharacterDto;
import com.gabrielrossilopes.fetcher.converter.CharacterDtoToCharacterConverter;
import com.gabrielrossilopes.fetcher.model.Character;
import com.gabrielrossilopes.fetcher.service.CharacterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConditionalOnProperty(prefix = "fetcher.loadDataRunner", name = "enabled", havingValue = "true")
public class LoadDataRunner implements ApplicationRunner {

    private static Logger logger = LoggerFactory.getLogger(LoadDataRunner.class);

    @Autowired
    private RickAndMortyApiClient rickAndMortyApiClient;

    @Autowired
    private CharacterService characterService;


    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<CharacterDto> characterDtos = rickAndMortyApiClient.getAllCharacters();
        logger.info("Got Characters list: " + characterDtos);
        List<Character> characters = characterDtos.stream().map(CharacterDtoToCharacterConverter::convert).toList();

        characters.forEach(characterService::save);

    }
}
