package com.codecool.shophandlerservice;

import com.codecool.shophandlerservice.controller.ShopController;
import org.junit.jupiter.api.Test;
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
    void getNewItemByCharacterIdAndCharacterLevel() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/1/1");
        mockMvc = MockMvcBuilders.standaloneSetup(shopController).build();
        mockMvc.perform(request).andExpect(status().is2xxSuccessful());
    }



}
