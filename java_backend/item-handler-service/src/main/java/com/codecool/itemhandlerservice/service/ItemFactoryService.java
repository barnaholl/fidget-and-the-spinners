package com.codecool.itemhandlerservice.service;

import com.codecool.itemhandlerservice.entity.Item;
import com.codecool.itemhandlerservice.model.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ItemFactoryService {

    private static final int NUMBER_OF_BASE_STATS=5;

    private static final int EPIC_ITEM_SELL_PRICE = 4;
    private static final int RARE_ITEM_SELL_PRICE = 3;
    private static final int UNCOMMON_ITEM_SELL_PRICE = 2;
    private static final int COMMON_ITEM_SELL_PRICE = 1;

    private static final int EPIC_ITEM_BUY_PRICE = 16;
    private static final int RARE_ITEM_BUY_PRICE = 9;
    private static final int UNCOMMON_ITEM_BUY_PRICE = 4;
    private static final int COMMON_ITEM_BUY_PRICE = 2;

    private static final int EPIC_ITEM_STAT_MULTIPLIER=4;
    private static final int RARE_ITEM_STAT_MULTIPLIER = 3;
    private static final int UNCOMMON_ITEM_STAT_MULTIPLIER = 2;
    private static final int COMMON_ITEM_STAT_MULTIPLIER = 1;
    private static final int MOTIVATION_BY_LEVEL = 2;


    public List<Item> getMultipleRandomItemsByPlayerLevel(Long playerLevel,int numberOfItems){
        if (playerLevel <= 0 || numberOfItems <= 0) {
            throw new IllegalArgumentException("Parameters should be positive");
        }
        List<Item> items=new ArrayList<>();
        for(int i=0; i<numberOfItems; i++){
            items.add(getRandomItemByPlayerLevel(playerLevel));
        }
        return items;
    }

    public Item getRandomItemByPlayerLevel(Long playerLevel){
        if (playerLevel <= 0) {
            throw new IllegalArgumentException("Input should be positive");
        }

        EquipmentSlot equipmentSlot=getRandomEquipmentSlot();
        Rarity rarity=getRandomRarity();
        Long overallStats=setOverallStats(playerLevel,rarity);

        Long[] stats=getRandomBaseStats(overallStats);

        Long problemSolvingStat=stats[0];
        Long algorithmizationStat=stats[1];
        Long designStat=stats[2];
        Long cleanCodeStat=stats[3];
        Long testingStat=stats[4];

        Long motivation=0L;

        Long debugging=0L;
        Long codingSpeed=0L;


        if(rarity==Rarity.RARE){
            motivation=getMotivation(playerLevel,rarity);
        }

        else if(rarity==Rarity.EPIC){
            motivation=getMotivation(playerLevel,rarity);
            debugging=getRandomSecondaryStat();
            codingSpeed=getRandomSecondaryStat();
        }


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
                .motivation(motivation)
                .debugging(debugging)
                .codingSpeed(codingSpeed)
                .sellPrice(getSellPrice(playerLevel,rarity))
                .buyPrice(getBuyPrice(playerLevel,rarity))
                .build();
    }

    private Long getRandomSecondaryStat() {
        Random random=new Random();
        return (long) random.nextInt(6);
    }

    private Long getMotivation(Long itemLevel,Rarity rarity) {
        if(rarity==Rarity.EPIC){
            return itemLevel*MOTIVATION_BY_LEVEL*2;
        }
        return itemLevel*MOTIVATION_BY_LEVEL;
    }

    private Long getBuyPrice(Long itemLevel,Rarity rarity) {
        switch(rarity) {
            case EPIC:
                return itemLevel*EPIC_ITEM_BUY_PRICE;
            case RARE:
                return itemLevel*RARE_ITEM_BUY_PRICE;
            case UNCOMMON:
                return itemLevel*UNCOMMON_ITEM_BUY_PRICE;
            case COMMON:
                return itemLevel*COMMON_ITEM_BUY_PRICE;
        }
        return null;
    }

    private Long getSellPrice(Long itemLevel,Rarity rarity) {
        switch(rarity) {
            case EPIC:
                return itemLevel*EPIC_ITEM_SELL_PRICE;
            case RARE:
                return itemLevel*RARE_ITEM_SELL_PRICE;
            case UNCOMMON:
                return itemLevel*UNCOMMON_ITEM_SELL_PRICE;
            case COMMON:
                return itemLevel*COMMON_ITEM_SELL_PRICE;
        }
        return null;
    }


    private Long[] getRandomBaseStats(Long overallStats) {
        Random random=new Random();
        Long[] stats= {0L, 0L, 0L, 0L, 0L};
        int i=0;
        while (overallStats>0){
            if(i==NUMBER_OF_BASE_STATS)
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
                return itemLevel*EPIC_ITEM_STAT_MULTIPLIER;
            case RARE:
                return itemLevel*RARE_ITEM_STAT_MULTIPLIER;
            case UNCOMMON:
                return itemLevel*UNCOMMON_ITEM_STAT_MULTIPLIER;
            case COMMON:
                return itemLevel*COMMON_ITEM_STAT_MULTIPLIER;
        }
        return null;
    }

    private Rarity getRandomRarity() {
        Random random=new Random();
        int chance=random.nextInt(100+1);
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
                return getRandomNameByType(ProgrammingLanguageName.class);
            case IDEA:
                return getRandomNameByType(IdeaName.class);
            case FRAMEWORK:
                return getRandomNameByType(FrameworkName.class);
            case COMPUTER:
                return getRandomNameByType(ComputerName.class);
            case ACCESSORY:
                return getRandomNameByType(AccessoryName.class);
        }
        return null;
    }

    private <T extends Enum<T>> String getRandomNameByType(Class<T> enumeration) {
        Random random=new Random();
        int i=random.nextInt(enumeration.getEnumConstants().length);
        return String.valueOf(enumeration.getEnumConstants()[i]);
    }

}
