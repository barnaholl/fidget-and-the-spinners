package com.codecool.characterhandlerservice.utility;

import com.codecool.characterhandlerservice.model.GameCharacter;
import com.codecool.characterhandlerservice.model.Inventory;
import com.codecool.characterhandlerservice.model.Item;

import java.util.Arrays;

public class InventoryMother {

    public static Inventory getInventoryWithSomeItems(GameCharacter gameCharacter) {
        Inventory newInventory = Inventory.builder()
                .gameCharacter(gameCharacter)
                .build();
        Item newItem1 = ItemMother.getInventoryItem(newInventory);
        Item newItem2 = ItemMother.getInventoryItem(newInventory);
        newInventory.setInventoryItems(Arrays.asList(newItem1, newItem2));

        return newInventory;
    }

}
