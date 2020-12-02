package com.codecool.itemhandlerservice;

import com.codecool.itemhandlerservice.entity.Item;
import com.codecool.itemhandlerservice.model.*;
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
        List<String> frameworkNames = Stream.of(FrameworkName.values())
                .map(Enum::name)
                .collect(Collectors.toList());
        List<String> ideaNames = Stream.of(IdeaName.values())
                .map(Enum::name)
                .collect(Collectors.toList());
        List<String> programmingLanguageNames = Stream.of(ProgrammingLanguageName.values())
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

        List<EquipmentSlot> equipmentSlots = Arrays.asList(EquipmentSlot.values());

        assertThat(item.getEquipmentSlot()).isIn(equipmentSlots);
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
    @Test
    void getRandomItemSumOfStatsIsIsEqualsOverallStats(){
        Item item=itemFactoryService.getRandomItem(1L);

        if(item.getRarity()==Rarity.COMMON){
            Long overallStats=item.getItemLevel();
            Long sumOfStats=item.getTesting()+item.getProblemSolving()+item.getAlgorithmization()+item.getDesign()+item.getCleanCode();
            assertThat(sumOfStats).isEqualTo(overallStats);
        }
        else if(item.getRarity()==Rarity.UNCOMMON){
            Long overallStats=item.getItemLevel()*2;
            Long sumOfStats=item.getTesting()+item.getProblemSolving()+item.getAlgorithmization()+item.getDesign()+item.getCleanCode();
            assertThat(sumOfStats).isEqualTo(overallStats);
        }
        else if(item.getRarity()==Rarity.RARE){
            Long overallStats=item.getItemLevel()*3;
            Long sumOfStats=item.getTesting()+item.getProblemSolving()+item.getAlgorithmization()+item.getDesign()+item.getCleanCode();
            assertThat(sumOfStats).isEqualTo(overallStats);
        }
        else{
            Long overallStats=item.getItemLevel()*4;
            Long sumOfStats=item.getTesting()+item.getProblemSolving()+item.getAlgorithmization()+item.getDesign()+item.getCleanCode();
            assertThat(sumOfStats).isEqualTo(overallStats);
        }

    }

    @Test
    void getRandomItemMotivationIsNotNull(){
        Item item=itemFactoryService.getRandomItem(1L);
        assertThat(item.getMotivation()).isNotNull();
    }


    @Test
    void getRandomItemMotivationInRange(){
        Item item=itemFactoryService.getRandomItem(1L);
        if(item.getRarity()==Rarity.RARE){
            assertThat(item.getMotivation()).isEqualTo(item.getMotivation()*2);
        }
        else if(item.getRarity()==Rarity.EPIC){
            assertThat(item.getMotivation()).isEqualTo(item.getMotivation()*4);
        }
        else {
            assertThat(item.getMotivation()).isEqualTo(0);
        }
    }
    @Test
    void getRandomItemDebuggingIsNotNull(){
        Item item=itemFactoryService.getRandomItem(1L);
        assertThat(item.getDebugging()).isNotNull();
    }

    @Test
    void getRandomItemDebuggingIsInRange(){
        Item item=itemFactoryService.getRandomItem(1L);
        if(item.getRarity()==Rarity.EPIC){
            assertThat(item.getDebugging()).isBetween(0L,5L);
        }
        else{
            assertThat(item.getDebugging()).isEqualTo(0L);
        }
    }

    @Test
    void getRandomItemCodingSpeedIsNotNull(){
        Item item=itemFactoryService.getRandomItem(1L);
        assertThat(item.getCodingSpeed()).isNotNull();
    }

    @Test
    void getRandomItemCodingSpeedIsInRange(){
        Item item=itemFactoryService.getRandomItem(1L);
        if(item.getRarity()==Rarity.EPIC){
            assertThat(item.getCodingSpeed()).isBetween(0L,5L);
        }
        assertThat(item.getCodingSpeed()).isEqualTo(0L);
    }

    @Test
    void getRandomItemSellPriceIsNotNull(){
        Item item=itemFactoryService.getRandomItem(1L);
        assertThat(item.getSellPrice()).isNotNull();
    }

    @Test
    void getRandomItemSellPriceIsEqualsWithExpected(){
        Item item=itemFactoryService.getRandomItem(1L);

        if(item.getRarity()==Rarity.COMMON){
            Long sellPrice=item.getItemLevel();
            assertThat(item.getSellPrice()).isEqualTo(sellPrice);
        }
        else if(item.getRarity()==Rarity.UNCOMMON){
            Long sellPrice=item.getItemLevel()*2;
            assertThat(item.getSellPrice()).isEqualTo(sellPrice);
        }
        else if(item.getRarity()==Rarity.RARE){
            Long sellPrice=item.getItemLevel()*3;
            assertThat(item.getSellPrice()).isEqualTo(sellPrice);
        }
        else{
            Long sellPrice=item.getItemLevel()*4;
            assertThat(item.getSellPrice()).isEqualTo(sellPrice);
        }

    }

    @Test
    void getRandomItemBuyPriceIsNotNull(){
        Item item=itemFactoryService.getRandomItem(1L);
        assertThat(item.getBuyPrice()).isNotNull();
    }

    @Test
    void getRandomItemBuyPriceIsEqualsWithExpected(){
        Item item=itemFactoryService.getRandomItem(1L);

        if(item.getRarity()==Rarity.COMMON){
            Long sellPrice=item.getItemLevel()*2;
            assertThat(item.getBuyPrice()).isEqualTo(sellPrice);
        }
        else if(item.getRarity()==Rarity.UNCOMMON){
            Long sellPrice=item.getItemLevel()*4;
            assertThat(item.getBuyPrice()).isEqualTo(sellPrice);
        }
        else if(item.getRarity()==Rarity.RARE){
            Long sellPrice=item.getItemLevel()*9;
            assertThat(item.getBuyPrice()).isEqualTo(sellPrice);
        }
        else{
            Long sellPrice=item.getItemLevel()*16;
            assertThat(item.getBuyPrice()).isEqualTo(sellPrice);
        }

    }



}
