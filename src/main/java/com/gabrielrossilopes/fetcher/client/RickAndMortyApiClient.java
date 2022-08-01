package com.gabrielrossilopes.fetcher.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gabrielrossilopes.fetcher.client.dto.CharacterDto;
import com.gabrielrossilopes.fetcher.client.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class RickAndMortyApiClient {

    @Autowired
    @Qualifier("rickAndMortyApiRestClient")
    private RestTemplate restTemplate;

    private static final ObjectMapper objectMapper;

    static {
            objectMapper = new ObjectMapper();
    }

    public List<CharacterDto> getAllCharacters() {
        ResponseDto response = restTemplate.getForEntity("/character", ResponseDto.class).getBody();
        List<CharacterDto> characterDtos = Arrays.stream(response.results).map(m -> objectMapper.convertValue(m, CharacterDto.class)).toList();

        return characterDtos;
    }
}
