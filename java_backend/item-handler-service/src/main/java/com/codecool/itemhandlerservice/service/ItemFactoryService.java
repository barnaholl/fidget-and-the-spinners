package com.codecool.itemhandlerservice.service;

import com.codecool.itemhandlerservice.entity.Item;
import com.codecool.itemhandlerservice.model.*;
import com.codecool.itemhandlerservice.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Random;

@Service
public class ItemFactoryService {
    private final ItemRepository itemRepository;

    public ItemFactoryService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
            }

    public Item getRandomItem(Long playerLevel){

        EquipmentSlot equipmentSlot=getRandomEquipmentSlot();
        Rarity rarity=getRandomRarity();
        Long overallStats=setOverallStats(playerLevel,rarity);

        Long problemSolvingStat=getRandomStat(overallStats);
        overallStats-=problemSolvingStat;

        Long algorithmizationStat=getRandomStat(overallStats);
        overallStats-=algorithmizationStat;

        Long designStat=getRandomStat(overallStats);
        overallStats-=designStat;

        Long cleanCodeStat=getRandomStat(overallStats);
        overallStats-=cleanCodeStat;

        Long testingStat=overallStats;



        Item item=Item.builder()
                .equipmentSlot(equipmentSlot)
                .name(getRandomName(equipmentSlot))
                .itemLevel(playerLevel)
                .rarity(rarity)
                .problemSolving(problemSolvingStat)
                .algorithmization(algorithmizationStat)
                .design(designStat)
                .cleanCode(cleanCodeStat)
                .testing(testingStat)
                .sellPrice(getSellPrice(playerLevel,rarity))
                .buyPrice(getBuyPrice(playerLevel,rarity))
                .build();

        return item;
    }

    private Long getBuyPrice(Long itemLevel,Rarity rarity) {
        switch(rarity) {
            case EPIC:
                return itemLevel*4*4;
            case RARE:
                return itemLevel*3*3;
            case UNCOMMON:
                return itemLevel*2*3;
            case COMMON:
                return itemLevel*1*2;
        }
        return null;
    }

    private Long getSellPrice(Long itemLevel,Rarity rarity) {
        switch(rarity) {
            case EPIC:
                return itemLevel*4;
            case RARE:
                return itemLevel*3;
            case UNCOMMON:
                return itemLevel*2;
            case COMMON:
                return itemLevel*1;
        }
        return null;
    }

    private Long getRandomStat(Long overallStat) {
        Random random=new Random();
        return Long.valueOf(random.nextInt(Math.toIntExact(overallStat)));
    }

    private Long setOverallStats(Long itemLevel, Rarity rarity) {
        switch(rarity) {
            case EPIC:
                return itemLevel*4;
            case RARE:
                return itemLevel*3;
            case UNCOMMON:
                return itemLevel*2;
            case COMMON:
                return itemLevel*1;
        }
        return null;
    }

    private Rarity getRandomRarity() {
        Random random=new Random();
        int chance=random.nextInt(100);
            if(chance>90)
                return Rarity.EPIC;
            else if (chance>70)
                return Rarity.RARE;
            else if (chance>40)
                return Rarity.UNCOMMON;
            else
                return Rarity.COMMON;
    }

    private EquipmentSlot getRandomEquipmentSlot() {
        Random random=new Random();
        int i=random.nextInt(EquipmentSlot.values().length);
        return (EquipmentSlot) Arrays.stream(EquipmentSlot.values()).toArray()[i];
    }

    private String getRandomName(EquipmentSlot equipmentSlot) {
        switch(equipmentSlot) {
            case LANGUAGE:
                return getRandomProgrammingLanguageName();
            case IDEA:
                return getRandomIdeaName();
            case FRAMEWORK:
                return getRandomFramework();
            case COMPUTER:
                return getRandomComputer();
        }
        return null;
    }

    private String getRandomComputer() {
        Random random=new Random();
        int i=random.nextInt(ComputerName.values().length);
        return String.valueOf(Arrays.stream(ComputerName.values()).toArray()[i]);
    }

    private String getRandomFramework() {
        Random random=new Random();
        int i=random.nextInt(FrameworkName.values().length);
        return String.valueOf(Arrays.stream(FrameworkName.values()).toArray()[i]);
    }

    private String getRandomIdeaName() {
        Random random=new Random();
        int i=random.nextInt(IdeaName.values().length);
        return String.valueOf(Arrays.stream(IdeaName.values()).toArray()[i]);
    }

    private String getRandomProgrammingLanguageName() {
        Random random=new Random();
        int i=random.nextInt(ProgrammingLanguageName.values().length);
        return String.valueOf(Arrays.stream(ProgrammingLanguageName.values()).toArray()[i]);
    }

}
