package com.codecool.shophandlerservice;

import com.codecool.shophandlerservice.entity.Item;
import com.codecool.shophandlerservice.service.ItemServiceCaller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ItemServiceCallerTest {

    @Autowired
    private ItemServiceCaller itemServiceCaller;

    @Test
    public void getItemIsNotNull(){
        Item item=itemServiceCaller.getItem(1L);
        assertThat(item).isNotNull();
    }

    @Test
    public void getItemIdIsNull(){
        Item item=itemServiceCaller.getItem(1L);
        assertThat(item.getId()).isNull();
    }

    @Test
    public void getItemCharacterIdIsNull(){
        Item item=itemServiceCaller.getItem(1L);
        assertThat(item.getCharacterId()).isNull();
    }
}
