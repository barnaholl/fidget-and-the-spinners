package com.codecool.itemhandlerservice;

import com.codecool.itemhandlerservice.entity.Item;
import com.codecool.itemhandlerservice.model.ComputerName;
import com.codecool.itemhandlerservice.model.Rarity;
import com.codecool.itemhandlerservice.service.ItemFactoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ItemFactoryServiceUnitTests {

    @Autowired
    private ItemFactoryService itemFactoryService;

    @Test
    void getRandomItemIsReturnWithItem(){
        assertThat(itemFactoryService.getRandomItem(1L)).isInstanceOf(Item.class);
    }

    @Test
    void getRandomItemNameIsNotNull(){
        Item item=itemFactoryService.getRandomItem(1L);
        assertThat(item.getName()).isNotNull();
    }

    @Test
    void getRandomItemNameIsInEnum(){
        Item item=itemFactoryService.getRandomItem(1L);

        List<String> names=new ArrayList<>();

        List<String> computerNames = Stream.of(ComputerName.values())
                .map(Enum::name)
                .collect(Collectors.toList());
        List<String> frameworkNames = Stream.of(ComputerName.values())
                .map(Enum::name)
                .collect(Collectors.toList());
        List<String> ideaNames = Stream.of(ComputerName.values())
                .map(Enum::name)
                .collect(Collectors.toList());
        List<String> programmingLanguageNames = Stream.of(ComputerName.values())
                .map(Enum::name)
                .collect(Collectors.toList());

        names.addAll(computerNames);
        names.addAll(frameworkNames);
        names.addAll(ideaNames);
        names.addAll(programmingLanguageNames);

        assertThat(item.getName()).isIn(names);
    }

    @Test
    void getRandomItemEquipmentSlotIsNotNull(){
        Item item=itemFactoryService.getRandomItem(1L);
        assertThat(item.getEquipmentSlot()).isNotNull();
    }
    @Test
    void getRandomItemEquipmentSlotIsInEnum(){
        Item item=itemFactoryService.getRandomItem(1L);

        List<String> equipmentSlots = Stream.of(ComputerName.values())
                .map(Enum::name)
                .collect(Collectors.toList());

        assertThat(item.getName()).isIn(equipmentSlots);
    }

    @Test
    void getRandomItemItemLevelIsNotNull(){
        Item item=itemFactoryService.getRandomItem(1L);
        assertThat(item.getItemLevel()).isNotNull();
    }

    @Test
    void getRandomItemItemLevelIsEqualsParam(){
        Long param=1L;
        Item item=itemFactoryService.getRandomItem(param);
        assertThat(item.getItemLevel()).isEqualTo(param);
    }

    @Test
    void getRandomItemRarityIsNotNull(){
        Item item=itemFactoryService.getRandomItem(1L);
        assertThat(item.getRarity()).isNotNull();
    }

    @Test
    void getRandomItemRarityIsInEnum(){
        Item item=itemFactoryService.getRandomItem(1L);

        List<Rarity> rarity = Arrays.asList(Rarity.values());

        assertThat(item.getRarity()).isIn(rarity);
    }

    @Test
    void getRandomItemProblemSolvingIsNotNull(){
        Item item=itemFactoryService.getRandomItem(1L);
        assertThat(item.getProblemSolving()).isNotNull();
    }



}
