package com.gabrielrossilopes.fetcher.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.client.RootUriTemplateHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplateHandler;

@Configuration
public class RickAndMortyApiConfig {

    @Value("${fetcher.rickAndMortyApi.url}")
    private String baseUrl;

    @Bean(name="rickAndMortyApiRestClient")
    public RestTemplate getRestClient(RestTemplateBuilder restTemplateBuilder) {
        UriTemplateHandler uriTemplateHandler = new RootUriTemplateHandler(baseUrl);
        return restTemplateBuilder
                .uriTemplateHandler(uriTemplateHandler)
                .build();
    }

}
