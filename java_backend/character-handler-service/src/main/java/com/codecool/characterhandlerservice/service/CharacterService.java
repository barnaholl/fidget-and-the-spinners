package com.codecool.characterhandlerservice.service;

import com.codecool.characterhandlerservice.repository.CharacterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CharacterService {

    private final CharacterRepository characterRepository;

    public Character getCharacterByUserId(Long userId) {
        return characterRepository.getCharacterByUserId(userId)
    }
}
