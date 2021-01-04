package com.codecool.shophandlerservice;

import com.codecool.shophandlerservice.controller.ShopController;
import com.codecool.shophandlerservice.entity.Item;
import com.codecool.shophandlerservice.repository.ItemRepository;
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ShopControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private ShopController shopController;

    @Autowired
    private ItemRepository itemRepository;


    @Test
    void getNewItemByCharacterIdAndCharacterLevelIsSuccessful() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/addItemToShop?characterId=1&characterLevel=1");
        mockMvc = MockMvcBuilders.standaloneSetup(shopController).build();
        mockMvc.perform(request).andExpect(status().is2xxSuccessful());
    }


    @ParameterizedTest
    @ValueSource(ints = {1,1,1,2,1,3})
    void getNewItemByCharacterIdAndCharacterLevelIsSuccessful(int characterId) throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/addItemToShop?characterId="+characterId+"&characterLevel=1");
        mockMvc = MockMvcBuilders.standaloneSetup(shopController).build();
        mockMvc.perform(request).andExpect(status().is2xxSuccessful());
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,10,100,Integer.MAX_VALUE})
    void getNewItemByCharacterIdAndCharacterLevelResponseIsCorrect(int characterId) throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/addItemToShop?characterId="+characterId+"&characterLevel=1");
        mockMvc = MockMvcBuilders.standaloneSetup(shopController).build();

        String response=mockMvc.perform(request).andReturn().getResponse().getContentAsString();

        assertThat(response).isEqualTo("A level "+ 1 + " item is successfully added to the shop of character with id: "+characterId);
    }

    @ParameterizedTest
    @ValueSource(ints = {0,-1,-2,-10,-100,Integer.MIN_VALUE})
    void getNewItemByCharacterIdAndCharacterLevelIsBadRequest1(int characterId) throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/addItemToShop?characterId="+characterId+"&characterLevel=1");
        mockMvc = MockMvcBuilders.standaloneSetup(shopController).build();
        mockMvc.perform(request).andExpect(status().isBadRequest());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,-1,-2,-10,-100,Integer.MIN_VALUE})
    void getNewItemByCharacterIdAndCharacterLevelResponseIsInCorrect1(int characterId) throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/addItemToShop?characterId="+characterId+"&characterLevel=1");
        mockMvc = MockMvcBuilders.standaloneSetup(shopController).build();

        String response=mockMvc.perform(request).andReturn().getResponse().getContentAsString();

        assertThat(response).isEqualTo("Params must be positive values");
    }

    @ParameterizedTest
    @ValueSource(ints = {0,-1,-2,-10,-100,Integer.MIN_VALUE})
    void getNewItemByCharacterIdAndCharacterLevelIsBadRequest2(int characterLevel) throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/addItemToShop?characterId="+1+"&characterLevel="+characterLevel);
        mockMvc = MockMvcBuilders.standaloneSetup(shopController).build();
        mockMvc.perform(request).andExpect(status().isBadRequest());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,-1,-2,-10,-100,Integer.MIN_VALUE})
    void getNewItemByCharacterIdAndCharacterLevelResponseIsCorrect2(int characterLevel) throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/addItemToShop?characterId="+1+"&characterLevel="+characterLevel);
        mockMvc = MockMvcBuilders.standaloneSetup(shopController).build();

        String response=mockMvc.perform(request).andReturn().getResponse().getContentAsString();

        assertThat(response).isEqualTo("Params must be positive values");
    }

    @Test
    void getNewItemByCharacterIdAndCharacterLevelElementIsInDB() throws Exception {
        itemRepository.deleteAll();
        RequestBuilder request = MockMvcRequestBuilders.post("/addItemToShop?characterId=1&characterLevel=1");
        mockMvc = MockMvcBuilders.standaloneSetup(shopController).build();

        mockMvc.perform(request);
        int size = itemRepository.findAll().size();

        assertThat(size).isEqualTo(1);
    }

    @Test
    void getItemsByCharacterIdIsSuccessful() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/getItemByCharacterId?characterId=1");
        mockMvc = MockMvcBuilders.standaloneSetup(shopController).build();
        mockMvc.perform(request).andExpect(status().is2xxSuccessful());
    }

    @Test
    void addMultipleItemsToShopByCharacterIdAndCharacterLevelIsSuccessful() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/addMultipleItemsToShop?characterId=1&characterLevel=1&numberOfItems=1");
        mockMvc = MockMvcBuilders.standaloneSetup(shopController).build();
        mockMvc.perform(request).andExpect(status().is2xxSuccessful());
    }

    @Test
    void refreshItemsByCharacterIdIsSuccessful() throws Exception {
        itemRepository.save(Item.builder().characterId(1L).build());
        RequestBuilder request = MockMvcRequestBuilders.put("/refreshShop?characterId=1&characterLevel=1");
        mockMvc = MockMvcBuilders.standaloneSetup(shopController).build();
        mockMvc.perform(request).andExpect(status().is2xxSuccessful());
    }

    @Test
    void buyItemIsSuccessful() throws Exception {
        itemRepository.save(Item.builder().build());
        RequestBuilder request = MockMvcRequestBuilders.get("/buyItem?id=1");
        mockMvc = MockMvcBuilders.standaloneSetup(shopController).build();
        mockMvc.perform(request).andExpect(status().is2xxSuccessful());
    }

}
