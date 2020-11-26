package com.codecool.itemhandlerservice.service;

import com.codecool.itemhandlerservice.entity.Item;
import com.codecool.itemhandlerservice.model.*;
import com.codecool.itemhandlerservice.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ItemFactoryService {
    private final ItemRepository itemRepository;
    private final int NUMBER_OF_STATS=5;

    public ItemFactoryService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item getRandomItem(Long playerLevel){

        EquipmentSlot equipmentSlot=getRandomEquipmentSlot();
        Rarity rarity=getRandomRarity();
        Long overallStats=setOverallStats(playerLevel,rarity);

        Long[] stats=getRandomStats(overallStats);

        Long problemSolvingStat=stats[0];
        Long algorithmizationStat=stats[1];
        Long designStat=stats[2];
        Long cleanCodeStat=stats[3];
        Long testingStat=stats[4];



        return Item.builder()
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

    private Long[] getRandomStats(Long overallStats) {
        Random random=new Random();
        Long[] stats= {0L, 0L, 0L, 0L, 0L};
        int i=0;
        while (overallStats>0){
            if(i==NUMBER_OF_STATS)
                i=0;
            if(random.nextBoolean()){
                int addedStat=random.nextInt(Math.toIntExact(overallStats)+1);
                overallStats-=addedStat;
                stats[i]+=addedStat;
            }
            i++;

        }
        return stats;
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
