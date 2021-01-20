package com.codecool.characterhandlerservice.utility;

import com.codecool.characterhandlerservice.model.Equipment;
import com.codecool.characterhandlerservice.model.GameCharacter;

public class EquipmentMother {

    public static Equipment getEmptyEquipment(GameCharacter gameCharacter) {
        return Equipment.builder()
                .gameCharacter(gameCharacter)
                .build();
    }

    public static Equipment getEquipmentWithIdeaSlotItem(GameCharacter gameCharacter) {
        Equipment newEquipment = Equipment.builder()
                .build();
        newEquipment.setIdea(ItemMother.getEquipmentItemOnIdeaSlot(newEquipment));
        return newEquipment;
    }

}
