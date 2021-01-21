package com.codecool.characterhandlerservice.utility;

import com.codecool.characterhandlerservice.model.*;

public class ItemMother {

    public static Item getInventoryItem(Inventory inventory) {
        return Item.builder()
                .algorithmization((long) 10)
                .buyPrice((long) 100)
                .cleanCode((long) 10)
                .design((long) 0)
                .inventory(inventory)
                .itemLevel((long) 10)
                .name("Sword")
                .problemSolving((long) 10)
                .rarity(Rarity.RARE)
                .sellPrice((long) 50)
                .testing((long) 1)
                .build();

    }

    public static Item getEquipmentItemOnIdeaSlot(Equipment equipment) {
        return Item.builder()
                .algorithmization((long) 10)
                .buyPrice((long) 100)
                .cleanCode((long) 10)
                .design((long) 0)
                .equipment(equipment)
                .equipmentSlot(EquipmentSlot.IDEA)
                .itemLevel((long) 10)
                .name("Sword")
                .problemSolving((long) 10)
                .rarity(Rarity.RARE)
                .sellPrice((long) 50)
                .testing((long) 1)
                .build();
    }

    public static Item getEquipmentItemOnComputerSlot(Equipment equipment) {
        return Item.builder()
                .algorithmization((long) 10)
                .buyPrice((long) 100)
                .cleanCode((long) 10)
                .design((long) 0)
                .equipment(equipment)
                .equipmentSlot(EquipmentSlot.COMPUTER)
                .itemLevel((long) 10)
                .name("Sword")
                .problemSolving((long) 10)
                .rarity(Rarity.RARE)
                .sellPrice((long) 50)
                .testing((long) 1)
                .build();
    }
}
