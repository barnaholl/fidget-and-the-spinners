package com.codecool.shophandlerservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Service
public class CharacterServiceCaller {
    private final RestTemplate restTemplate;

    public CharacterServiceCaller(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${character.handler.service.url}")
    private String characterServiceUrl;


    public HashMap<String,Integer> getCharacterLevels() {
        return restTemplate.getForObject("http://localhost:8081/character/characterLevels", HashMap.class);
    }
}
