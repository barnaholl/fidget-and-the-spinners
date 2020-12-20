package com.codecool.characterhandlerservice;

import com.codecool.characterhandlerservice.model.GameCharacter;
import com.codecool.characterhandlerservice.repository.CharacterRepository;
import com.codecool.characterhandlerservice.service.CharacterService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.NoResultException;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CharacterServiceTests {

    @Autowired
    private CharacterService characterService;

    @Autowired
    private CharacterRepository characterRepository;

    @Test
    void getAllCharacterIdAndLevelMapIsEmpty(){
        Assertions.assertThrows(NoResultException.class, () -> characterService.getAllCharacterIdAndLevel());
    }

    @Test
    void getAllCharacterIdAndLevelMapIsNotEmpty(){
        GameCharacter gameCharacter= GameCharacter.builder().build();
        characterRepository.save(gameCharacter);

        Map map=characterService.getAllCharacterIdAndLevel();

        assertThat(map).isNotEmpty();
    }

    @Test
    void getAllCharacterIdAndLevelFirstValueIsCorrect(){
        GameCharacter gameCharacter= GameCharacter.builder().characterLevel(5).build();
        characterRepository.save(gameCharacter);

        Map map=characterService.getAllCharacterIdAndLevel();

        assertThat(map.get(1L)).isEqualTo(5L);
    }

    @Test
    void getAllCharacterIdAndLevelSecondValueIsCorrect(){
        GameCharacter gameCharacter= GameCharacter.builder().characterLevel(5).build();
        GameCharacter gameCharacter2= GameCharacter.builder().characterLevel(100).build();
        characterRepository.save(gameCharacter);
        characterRepository.save(gameCharacter2);

        Map map=characterService.getAllCharacterIdAndLevel();

        assertThat(map.get(2L)).isEqualTo(100L);
    }


    @ParameterizedTest
    @ValueSource(ints = {1,2,10,100})
    void getAllCharacterIdAndLevelMapSizeIsCorrect(int param){
        for (int i = 0; i < param; i++) {
            GameCharacter gameCharacter= GameCharacter.builder().characterLevel(1).build();
            characterRepository.save(gameCharacter);
        }
        Map map=characterService.getAllCharacterIdAndLevel();

        assertThat(map.size()).isEqualTo(param);
        characterRepository.deleteAll();
    }

}
