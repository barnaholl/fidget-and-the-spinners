package com.codecool.shophandlerservice.service;

import com.codecool.shophandlerservice.entity.Item;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class CharacterServiceCaller {
    private final RestTemplate restTemplate;

    public CharacterServiceCaller(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${character.handler.service.url}")
    private String characterServiceUrl;


    public Map getCharacterLevels() {
        return restTemplate.getForObject(characterServiceUrl+"characterLevels", Map.class);
    }
}
