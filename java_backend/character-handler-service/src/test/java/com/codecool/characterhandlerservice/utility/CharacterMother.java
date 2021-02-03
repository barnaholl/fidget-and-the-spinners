package com.codecool.characterhandlerservice.utility;

import com.codecool.characterhandlerservice.model.GameCharacter;

import static com.codecool.characterhandlerservice.model.CharacterClass.TESTER;

public class CharacterMother {

    public static GameCharacter getTesterCharacterWithEquipmentAndInventoryItems() {
        GameCharacter newGameCharacter = GameCharacter.builder()
                .characterLevel(10)
                .characterClass(TESTER)
                .characterCurrency((long) 1000)
                .characterName("TesterCharacter")
                .energyLevel(2000)
                .characterExperience((long) 2000)
                .build();

        newGameCharacter.setCharacterStatistics(StatisticsMother.getCharacterStatistics(newGameCharacter));
        newGameCharacter.setCharacterInventory(InventoryMother.getInventoryWithSomeItems(newGameCharacter));
        newGameCharacter.setCharacterEquipment(EquipmentMother.getEmptyEquipment(newGameCharacter));

        return newGameCharacter;
    }

}
