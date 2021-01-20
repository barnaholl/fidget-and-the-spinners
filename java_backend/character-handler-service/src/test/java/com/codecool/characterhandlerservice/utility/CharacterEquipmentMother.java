package com.codecool.characterhandlerservice.utility;

import com.codecool.characterhandlerservice.model.Equipment;
import com.codecool.characterhandlerservice.model.GameCharacter;
import com.codecool.characterhandlerservice.model.Item;

public class CharacterEquipmentMother {

    public static Equipment getEmptyEquipment(GameCharacter gameCharacter) {
        return Equipment.builder()
                .gameCharacter(gameCharacter)
                .build();
    }

    public static Equipment getEquipmentWithIdeaSlotItem(GameCharacter gameCharacter) {
        Equipment newEquipment = Equipment.builder()
                .build();
        newEquipment.setIdea(CharacterItemMother.getEquipmentItemOnIdeaSlot(newEquipment));
        return newEquipment;
    }

}
