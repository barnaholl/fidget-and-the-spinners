package com.codecool.characterhandlerservice.service;

import com.codecool.characterhandlerservice.model.GameCharacter;
import com.codecool.characterhandlerservice.model.Statistics;
import com.codecool.characterhandlerservice.repository.CharacterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class CharacterService {

    private final CharacterRepository characterRepository;
    private final StatisticsService statisticsService;

    public GameCharacter getCharacterByUserId(Long userId) {
        return characterRepository
                .getCharacterByUserId(userId)
                .orElseThrow(() -> new EntityNotFoundException("Character not found by user id"));
    }

    public GameCharacter saveCharacter(Long userId) {
        return characterRepository.save(GameCharacter.builder()
        .characterStatistics(statisticsService.getStarterStatistics);
    }
}
