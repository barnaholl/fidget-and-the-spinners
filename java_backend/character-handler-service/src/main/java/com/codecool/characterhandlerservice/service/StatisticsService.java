package com.codecool.characterhandlerservice.service;

import com.codecool.characterhandlerservice.model.CharacterClass;
import com.codecool.characterhandlerservice.model.GameCharacter;
import com.codecool.characterhandlerservice.model.Statistics;
import com.codecool.characterhandlerservice.repository.CharacterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class StatisticsService {

    private final CharacterRepository characterRepository;

    private static final int STARTER_VALUE_OF_BASE_STATS = 1;


    public Statistics getStarterStatistics(CharacterClass characterClass) {

        return Statistics.builder()
                .algorithm(STARTER_VALUE_OF_BASE_STATS+characterClass.getMap().get("algorithm"))
                .cleanCode(STARTER_VALUE_OF_BASE_STATS+characterClass.getMap().get("cleanCode"))
                .design(STARTER_VALUE_OF_BASE_STATS+characterClass.getMap().get("design"))
                .problemSolving(STARTER_VALUE_OF_BASE_STATS+characterClass.getMap().get("problemSolving"))
                .testing(STARTER_VALUE_OF_BASE_STATS+characterClass.getMap().get("testing"))
                .motivation(STARTER_VALUE_OF_BASE_STATS)
                .debugChance(STARTER_VALUE_OF_BASE_STATS)
                .fastCoding(STARTER_VALUE_OF_BASE_STATS)
                .build();
    }

    public Statistics getStatisticsByCharacterId(Long characterId){
        GameCharacter gameCharacter = characterRepository.findById(characterId)
                                        .orElseThrow(()->new EntityNotFoundException());
        return gameCharacter.getCharacterStatistics();
    }
}
