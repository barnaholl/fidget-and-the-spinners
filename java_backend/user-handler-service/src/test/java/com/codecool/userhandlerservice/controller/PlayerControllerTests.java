package com.codecool.userhandlerservice.controller;


import com.codecool.userhandlerservice.repository.PlayerRepository;
import com.codecool.userhandlerservice.service.PlayerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DataJpaTest
public class PlayerControllerTests {

    @Autowired
    private PlayerRepository allPlayers;

    PlayerService playerService;

    PlayerController playerController;

    @BeforeEach
    void initialize() {
        playerService = new PlayerService(allPlayers);
        playerController = new PlayerController(playerService);
    }

    @Test
    public void contextLoads() throws Exception {
        assertThat(playerController).isNotNull();
    }

    @Test
    void testZeroPlayersInDatabase() {
        assertThat(playerService.getAllPlayers()).hasSize(0);
        assertEquals(playerService.getAllPlayers(), playerController.getAllPlayers());
    }

    @Test
    void testValidInputForGetPlayersThenReturns200StatusCode() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new PlayerController(this.playerService)).build();
        mockMvc.perform(MockMvcRequestBuilders
                .get("/players")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testValidInputForPostThenReturns4xxStatusCode() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new PlayerController(this.playerService)).build();
        mockMvc.perform(MockMvcRequestBuilders
                .post("/players")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


}
