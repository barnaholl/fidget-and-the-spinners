package com.codecool.characterhandlerservice.service;

import com.codecool.characterhandlerservice.model.GameCharacter;
import com.codecool.characterhandlerservice.model.Inventory;
import com.codecool.characterhandlerservice.model.Statistics;
import com.codecool.characterhandlerservice.repository.CharacterRepository;
import com.codecool.characterhandlerservice.service.StatisticsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class StatisticsServiceTest {

    @Autowired
    private StatisticsService statisticsService;

    @Autowired
    private CharacterRepository characterRepository;

    @Test
    void getStatisticsThrowsErrorForBadId(){
        Assertions.assertThrows(EntityNotFoundException.class, () ->statisticsService.getStatisticsByCharacterId(1L));
    }

    @Test
    void getStatisticsIsNotNull(){

        Statistics characterStatistics=Statistics.builder().build();
        GameCharacter gameCharacter= GameCharacter.builder().characterStatistics(characterStatistics).build();
        characterRepository.save(gameCharacter);

        Statistics statistics = statisticsService.getStatisticsByCharacterId(1L);

        assertThat(statistics).isNotNull();
    }


    @Test
    void getStatisticsAlgorithmIsEqualTo1(){

        Statistics characterStatistics=Statistics.builder().algorithm(1).build();
        GameCharacter gameCharacter= GameCharacter.builder().characterStatistics(characterStatistics).build();
        characterRepository.save(gameCharacter);

        Statistics statistics = statisticsService.getStatisticsByCharacterId(1L);

        assertThat(statistics.getAlgorithm()).isEqualTo(1);

    }

    @Test
    void updateStatisticsThrowsErrorForBadId(){
        Assertions.assertThrows(EntityNotFoundException.class, () ->statisticsService.updateStatisticsByCharacterId(1L, Statistics.builder().build()));
    }

    @Test
    void updateStatisticsIsNotNull(){

        Statistics characterStatistics=Statistics.builder().build();
        GameCharacter gameCharacter= GameCharacter.builder().characterStatistics(characterStatistics).build();
        characterRepository.save(gameCharacter);

        statisticsService.updateStatisticsByCharacterId(1L,Statistics.builder().algorithm(1).build());

        gameCharacter = characterRepository.findById(1L).orElseThrow();
        int algorithm=gameCharacter.getCharacterStatistics().getAlgorithm();
        assertThat(algorithm).isNotNull();
    }

    @Test
    void updateStatisticsIsCorrect(){

        Statistics characterStatistics=Statistics.builder().build();
        GameCharacter gameCharacter= GameCharacter.builder().characterStatistics(characterStatistics).build();
        characterRepository.save(gameCharacter);

        Statistics newStatistics=Statistics.builder().algorithm(10).build();
        statisticsService.updateStatisticsByCharacterId(1L,newStatistics);

        gameCharacter = characterRepository.findById(1L).orElseThrow();
        Integer algorithm=gameCharacter.getCharacterStatistics().getAlgorithm();
        assertThat(algorithm).isEqualTo(10);


    }

}
