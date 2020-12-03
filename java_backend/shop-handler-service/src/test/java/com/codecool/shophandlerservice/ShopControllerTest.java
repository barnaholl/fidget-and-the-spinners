package com.codecool.shophandlerservice;

import com.codecool.shophandlerservice.controller.ShopController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ShopControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private ShopController shopController;

    @Test
    void getNewItemByCharacterIdAndCharacterLevelIsSuccessful() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/1/1");
        mockMvc = MockMvcBuilders.standaloneSetup(shopController).build();
        mockMvc.perform(request).andExpect(status().is2xxSuccessful());
    }

    @ParameterizedTest
    @ValueSource(ints = {1,1,1,2,1,3})
    void getNewItemByCharacterIdAndCharacterLevelIsSuccessfulForMultipleRequests(int characterId) throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/"+characterId+"/1");
        mockMvc = MockMvcBuilders.standaloneSetup(shopController).build();
        mockMvc.perform(request).andExpect(status().is2xxSuccessful());
    }



}
