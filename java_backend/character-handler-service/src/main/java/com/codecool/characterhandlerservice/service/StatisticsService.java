package com.codecool.characterhandlerservice.service;

import com.codecool.characterhandlerservice.model.CharacterClass;
import com.codecool.characterhandlerservice.model.Statistics;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatisticsService {

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
}
