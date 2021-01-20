package com.codecool.characterhandlerservice.utility;

import com.codecool.characterhandlerservice.model.GameCharacter;
import com.codecool.characterhandlerservice.model.Inventory;

public class CharacterInventoryMother {

    public static Inventory getInventoryWithSomeItems(GameCharacter gameCharacter) {
        Inventory newInventory = Inventory.builder()
                .gameCharacter(gameCharacter)
                .build();

        newInventory
    }

}
