package com.gabrielrossilopes.fetcher;

import com.gabrielrossilopes.fetcher.client.RickAndMortyApiClient;
import com.gabrielrossilopes.fetcher.client.dto.CharacterDto;
import com.gabrielrossilopes.fetcher.converter.CharacterDtoToCharacterConverter;
import com.gabrielrossilopes.fetcher.model.Character;
import com.gabrielrossilopes.fetcher.service.CharacterService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class FetcherApplicationTests {

	private static Logger logger = LoggerFactory.getLogger(FetcherApplicationTests.class);

	@Autowired
	private RickAndMortyApiClient rickAndMortyApiClient;

	@Autowired
	private CharacterService characterService;


	@Test
	void contextLoads() throws Exception {
		Assertions.assertNotNull(rickAndMortyApiClient);
	}

	@Test
	void assertThatSavesAllCharacters() throws Exception {
		List<CharacterDto> characterDtos = rickAndMortyApiClient.getAllCharacters();
		logger.info("Got Characters list: " + characterDtos);
		List<Character> characters = characterDtos.stream().map(CharacterDtoToCharacterConverter::convert).toList();

		characters.forEach(characterService::save);

		List<Character> savedCharacters = characterService.findAll();
		Assertions.assertEquals(savedCharacters.size(), characterDtos.size());
	}
}
