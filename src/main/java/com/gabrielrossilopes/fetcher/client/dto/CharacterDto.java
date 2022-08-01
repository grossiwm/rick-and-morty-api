package com.gabrielrossilopes.fetcher.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterDto {
    private String name;
    private String status;
    private String species;
    private String gender;
}