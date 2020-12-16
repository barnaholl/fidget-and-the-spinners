package com.codecool.characterhandlerservice;

import com.codecool.characterhandlerservice.service.CharacterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CharacterServiceTests {

    @Autowired
    private CharacterService characterService;

    @Test
    void getAllCharacterIdAndLevelMapIsEmpty(){
        Map map=characterService.getAllCharacterIdAndLevel();
        assertThat(map).isEmpty();
    }
}
