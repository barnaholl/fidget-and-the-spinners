package com.codecool.itemhandlerservice.service;

import com.codecool.itemhandlerservice.entity.Item;
import com.codecool.itemhandlerservice.model.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ItemFactoryService {

    public List<Item> getMultipleRandomItemsByPlayerLevel(Long playerLevel, int numberOfItems){
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

        Map<BaseStats,Long> baseStats=getRandomBaseStats(overallStats);

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
                .problemSolving(baseStats.get(BaseStats.PROBLEM_SOLVING))
                .algorithmization(baseStats.get(BaseStats.ALGORITHMIZATION))
                .design(baseStats.get(BaseStats.DESIGN))
                .cleanCode(baseStats.get(BaseStats.CLEAN_CODE))
                .testing(baseStats.get(BaseStats.TESTING))
                .motivation(motivation)
                .debugging(debugging)
                .codingSpeed(codingSpeed)
                .sellPrice(getSellPrice(playerLevel,rarity))
                .buyPrice(getBuyPrice(playerLevel,rarity))
                .build();
    }

    private Long getRandomSecondaryStat() {
        Random random=new Random();
        return (long) random.nextInt(5+1);
    }

    private Long getMotivation(Long itemLevel,Rarity rarity) {
        return rarity.getMap().get("motivation")*itemLevel;
    }

    private Long getBuyPrice(Long itemLevel,Rarity rarity) {
        return rarity.getMap().get("buyPrice")*itemLevel;
    }

    private Long getSellPrice(Long itemLevel,Rarity rarity) {
        return rarity.getMap().get("sellPrice")*itemLevel;
    }

    private Long setOverallStats(Long itemLevel, Rarity rarity) {
        return rarity.getMap().get("statMultiplier")*itemLevel;
    }

    private Map<BaseStats,Long> getRandomBaseStats(Long overallStats) {
        Random random=new Random();

        Map<BaseStats,Long> stats=new HashMap<>();
        List<BaseStats> keys = Arrays.asList(BaseStats.values());

        for (BaseStats key: keys) {
            stats.put(key,0L);
        }

        while (overallStats>0){
            BaseStats statToImprove = keys.get(random.nextInt(keys.size()));
            int addedStat=random.nextInt(Math.toIntExact(overallStats)+1);
            overallStats-=addedStat;
            stats.put(statToImprove,stats.getOrDefault(statToImprove,0L)+addedStat);
        }
        return stats;
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
       return getRandomNameByType(equipmentSlot.getEnum());
    }

    private <T extends Enum<T>> String getRandomNameByType(Class<T> enumeration) {
        Random random=new Random();
        int i=random.nextInt(enumeration.getEnumConstants().length);
        return String.valueOf(enumeration.getEnumConstants()[i]);
    }

}
