package com.codecool.characterhandlerservice.utility;

import com.codecool.characterhandlerservice.model.GameCharacter;
import com.codecool.characterhandlerservice.model.Statistics;

public class CharacterStatisticsMother {

    public static Statistics getCharacterStatistics(GameCharacter gameCharacter) {
        return Statistics.builder()
                .fastCoding(10)
                .debugChance(10)
                .testing(100)
                .problemSolving(10)
                .motivation(10)
                .design(10)
                .cleanCode(10)
                .algorithm(10)
                .gameCharacter(gameCharacter)
                .build();
    }
}
