package com.codecool.characterhandlerservice.service;

import com.codecool.characterhandlerservice.model.Inventory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService {

    public Inventory getNewInventory() {
        return Inventory.builder().build();
    }
}
