package com.codecool.shophandlerservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class CharacterServiceCaller {
    private final RestTemplate restTemplate;

    public CharacterServiceCaller(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${character.handler.service.url}")
    private String characterServiceUrl;


    public Map<Long,Long> getCharacterLevels() {
        return restTemplate.getForObject("http://localhost:8081/character/characterLevels", HashMap.class);
    }
}
