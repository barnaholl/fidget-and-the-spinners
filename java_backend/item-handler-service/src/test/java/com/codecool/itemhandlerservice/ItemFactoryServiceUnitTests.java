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

    @Test
    void getRandomItemProblemSolvingIsInRange(){
        Item item=itemFactoryService.getRandomItem(1L);

        if(item.getRarity()==Rarity.COMMON){
            Long overallStats=item.getItemLevel();
            assertThat(item.getProblemSolving()).isBetween(0L,overallStats);
        }
        else if(item.getRarity()==Rarity.UNCOMMON){
            Long overallStats=item.getItemLevel()*2;
            assertThat(item.getProblemSolving()).isBetween(0L,overallStats);
        }
        else if(item.getRarity()==Rarity.RARE){
            Long overallStats=item.getItemLevel()*3;
            assertThat(item.getProblemSolving()).isBetween(0L,overallStats);
        }
        else{
            Long overallStats=item.getItemLevel()*4;
            assertThat(item.getProblemSolving()).isBetween(0L,overallStats);
        }
    }
    @Test
    void getRandomItemDesignIsNotNull(){
        Item item=itemFactoryService.getRandomItem(1L);
        assertThat(item.getDesign()).isNotNull();
    }

    @Test
    void getRandomItemDesignInRange(){
        Item item=itemFactoryService.getRandomItem(1L);

        if(item.getRarity()==Rarity.COMMON){
            Long overallStats=item.getItemLevel();
            assertThat(item.getDesign()).isBetween(0L,overallStats);
        }
        else if(item.getRarity()==Rarity.UNCOMMON){
            Long overallStats=item.getItemLevel()*2;
            assertThat(item.getDesign()).isBetween(0L,overallStats);
        }
        else if(item.getRarity()==Rarity.RARE){
            Long overallStats=item.getItemLevel()*3;
            assertThat(item.getDesign()).isBetween(0L,overallStats);
        }
        else{
            Long overallStats=item.getItemLevel()*4;
            assertThat(item.getDesign()).isBetween(0L,overallStats);
        }
    }
    @Test
    void getRandomItemAlgorithmizationIsNotNull(){
        Item item=itemFactoryService.getRandomItem(1L);
        assertThat(item.getAlgorithmization()).isNotNull();
    }
    @Test
    void getRandomItemAlgorithmizationInRange(){
        Item item=itemFactoryService.getRandomItem(1L);

        if(item.getRarity()==Rarity.COMMON){
            Long overallStats=item.getItemLevel();
            assertThat(item.getAlgorithmization()).isBetween(0L,overallStats);
        }
        else if(item.getRarity()==Rarity.UNCOMMON){
            Long overallStats=item.getItemLevel()*2;
            assertThat(item.getAlgorithmization()).isBetween(0L,overallStats);
        }
        else if(item.getRarity()==Rarity.RARE){
            Long overallStats=item.getItemLevel()*3;
            assertThat(item.getAlgorithmization()).isBetween(0L,overallStats);
        }
        else{
            Long overallStats=item.getItemLevel()*4;
            assertThat(item.getAlgorithmization()).isBetween(0L,overallStats);
        }
    }
    @Test
    void getRandomItemCleanCodeIsNotNull(){
        Item item=itemFactoryService.getRandomItem(1L);
        assertThat(item.getCleanCode()).isNotNull();
    }

    @Test
    void getRandomItemCleanCodeInRange(){
        Item item=itemFactoryService.getRandomItem(1L);

        if(item.getRarity()==Rarity.COMMON){
            Long overallStats=item.getItemLevel();
            assertThat(item.getCleanCode()).isBetween(0L,overallStats);
        }
        else if(item.getRarity()==Rarity.UNCOMMON){
            Long overallStats=item.getItemLevel()*2;
            assertThat(item.getCleanCode()).isBetween(0L,overallStats);
        }
        else if(item.getRarity()==Rarity.RARE){
            Long overallStats=item.getItemLevel()*3;
            assertThat(item.getCleanCode()).isBetween(0L,overallStats);
        }
        else{
            Long overallStats=item.getItemLevel()*4;
            assertThat(item.getCleanCode()).isBetween(0L,overallStats);
        }
    }

    @Test
    void getRandomItemTestingIsNotNull(){
        Item item=itemFactoryService.getRandomItem(1L);
        assertThat(item.getTesting()).isNotNull();
    }

    @Test
    void getRandomItemTestingInRange(){
        Item item=itemFactoryService.getRandomItem(1L);

        if(item.getRarity()==Rarity.COMMON){
            Long overallStats=item.getItemLevel();
            assertThat(item.getTesting()).isBetween(0L,overallStats);
        }
        else if(item.getRarity()==Rarity.UNCOMMON){
            Long overallStats=item.getItemLevel()*2;
            assertThat(item.getTesting()).isBetween(0L,overallStats);
        }
        else if(item.getRarity()==Rarity.RARE){
            Long overallStats=item.getItemLevel()*3;
            assertThat(item.getTesting()).isBetween(0L,overallStats);
        }
        else{
            Long overallStats=item.getItemLevel()*4;
            assertThat(item.getTesting()).isBetween(0L,overallStats);
        }
    }

}
