package com.codecool.characterhandlerservice.controller;

import com.codecool.characterhandlerservice.controller.CharacterController;
import com.codecool.characterhandlerservice.model.GameCharacter;
import com.codecool.characterhandlerservice.repository.CharacterRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CharacterControllerTests {

    private MockMvc mockMvc;

    @Autowired
    private CharacterController characterController;

    @Autowired
    private CharacterRepository characterRepository;

    @Test
    void getCharacterIsSuccessful() throws Exception {
        characterRepository.save(GameCharacter.builder().userId(1L).build());
        RequestBuilder request = MockMvcRequestBuilders.get("/character/?userId=1");
        mockMvc = MockMvcBuilders.standaloneSetup(characterController).build();
        mockMvc.perform(request).andExpect(status().is2xxSuccessful());
    }

    @Test
    void getCharacter() throws Exception {
        characterRepository.save(GameCharacter.builder().userId(1L).build());
        RequestBuilder request = MockMvcRequestBuilders.get("/character/?userId=2");
        mockMvc = MockMvcBuilders.standaloneSetup(characterController).build();
        mockMvc.perform(request).andExpect(result -> assertTrue(result.getResolvedException() instanceof Exception));
    }

    @Test
    void getNewItemByCharacterIdAndCharacterLevelIsSuccessful() throws Exception {
        characterRepository.save(GameCharacter.builder().characterLevel(10).build());
        RequestBuilder request = MockMvcRequestBuilders.get("/character/characterLevels");
        mockMvc = MockMvcBuilders.standaloneSetup(characterController).build();
        mockMvc.perform(request).andExpect(status().is2xxSuccessful());
    }
}
