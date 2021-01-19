package com.codecool.characterhandlerservice.service;

import com.codecool.characterhandlerservice.model.GameCharacter;
import com.codecool.characterhandlerservice.repository.CharacterRepository;
import com.codecool.characterhandlerservice.service.CharacterService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CharacterServiceTests {

    @Autowired
    private CharacterService characterService;

    @Autowired
    private CharacterRepository characterRepository;

    @Test
    void getCharacterByUserIdThrowsErrorForEmptyRepository(){
        Assertions.assertThrows(EntityNotFoundException.class, ()-> characterService.getCharacterByUserId(1L));
    }

    @Test
    void getCharacterByUserIdSaveToRepository(){
        characterService.saveNewCharacter(1L,"Test","FRONT_END");

        Optional<GameCharacter> gameCharacter=characterRepository.findById(1L);

        assertThat(gameCharacter).isNotNull();
    }

    @Test
    void getCharacterByUserIdSaveToRepositoryMultipleTimes(){
        characterService.saveNewCharacter(1L,"Test","FRONT_END");
        characterService.saveNewCharacter(2L,"Test2","FRONT_END");
        characterService.saveNewCharacter(3L,"Test3","FRONT_END");

        List<GameCharacter> gameCharacterList=characterRepository.findAll();

        assertThat(gameCharacterList).isNotEmpty();
    }


    @Test
    void updateCharacterOverridesGameCharacter(){
        GameCharacter gameCharacter= GameCharacter.builder().userId(1L).build();
        characterRepository.save(gameCharacter);

        characterService.updateCharacter(GameCharacter.builder().id(1L).userId(2L).build());

        List<GameCharacter> gameCharacterList=characterRepository.findAll();
        assertThat(gameCharacterList.size()).isEqualTo(1);
    }

    @Test
    void updateCharacterKeepsId(){
        GameCharacter gameCharacter= GameCharacter.builder().userId(1L).build();
        characterRepository.save(gameCharacter);

        characterService.updateCharacter(GameCharacter.builder().id(1L).userId(2L).build());

        Optional<GameCharacter> newCharacter=characterRepository.findById(1L);
        assertThat(newCharacter.get().getId()).isEqualTo(gameCharacter.getId());
    }

    @Test
    void updateCharacterChangeUserId(){
        GameCharacter gameCharacter= GameCharacter.builder().userId(1L).build();
        characterRepository.save(gameCharacter);

        characterService.updateCharacter(GameCharacter.builder().id(1L).userId(2L).build());

        Optional<GameCharacter> newCharacter=characterRepository.findById(1L);
        assertThat(newCharacter.get().getUserId()).isNotEqualTo(gameCharacter.getUserId());
    }


    @Test
    void getCharacterByUserIdThrowsErrorForBadId(){
        GameCharacter newCharacter= GameCharacter.builder().userId(1L).build();
        characterRepository.save(newCharacter);
    }

    @Test
    void getCharacterByUserIdFindsEntity(){
        GameCharacter newCharacter= GameCharacter.builder().userId(1L).build();
        characterRepository.save(newCharacter);

        GameCharacter gameCharacter=characterService.getCharacterByUserId(1L);

        assertThat(gameCharacter).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(longs = {0,-1,-10,Long.MIN_VALUE})
    void saveNewCharacterThrowsExceptionForBadId(long param){
        Assertions.assertThrows(IllegalArgumentException.class, ()-> characterService.saveNewCharacter(param,"TestName","FRONT_END"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"","aaaa","front_end","FRONT_ENd"})
    void saveNewCharacterThrowsExceptionForBadClass(String param){
        Assertions.assertThrows(NoResultException.class, ()-> characterService.saveNewCharacter(1L,"TestName",param));
    }

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
