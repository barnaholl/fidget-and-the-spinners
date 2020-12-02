package com.codecool.itemhandlerservice;

import com.codecool.itemhandlerservice.controller.ItemController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ItemFactoryControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private ItemController itemController;

    @Test
    void getItemByLevelSuccessfulStatus() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/1");
        mockMvc = MockMvcBuilders.standaloneSetup(itemController).build();
        mockMvc.perform(request).andExpect(status().is2xxSuccessful());
    }
    @Test
    public void getItemByLevelItemLevelIs1() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/1");
        mockMvc = MockMvcBuilders.standaloneSetup(itemController).build();
        MvcResult result=mockMvc.perform(request).andReturn();
        assertThat(result.getResponse().getContentAsString().contains("\"itemLevel\":1")).isTrue();
    }

    @Test
    public void getItemByLevelItemLevelIs100() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/100");
        mockMvc = MockMvcBuilders.standaloneSetup(itemController).build();
        MvcResult result=mockMvc.perform(request).andReturn();
        assertThat(result.getResponse().getContentAsString().contains("\"itemLevel\":100")).isTrue();
    }


}
