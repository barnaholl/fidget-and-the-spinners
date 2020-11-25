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

        System.out.println("AAAAAAAAA");
        System.out.println(getRandomRarity());
        System.out.println(getRandomRarity());
        System.out.println(getRandomRarity());
        System.out.println(getRandomRarity());
        System.out.println(getRandomRarity());
        System.out.println(getRandomRarity());
        System.out.println(getRandomRarity());
        System.out.println(getRandomRarity());


    }

    public Item getRandomItem(Long playerLevel){

        EquipmentSlot equipmentSlot=getRandomEquipmentSlot();

        Item item=Item.builder()
                .equipmentSlot(equipmentSlot)
                .name(getRandomName(equipmentSlot))
                .itemLevel(playerLevel)
                .rarity(getRandomRarity())
                .build();

        return item;
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
