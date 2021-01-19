package com.codecool.characterhandlerservice;

import com.codecool.characterhandlerservice.model.GameCharacter;
import com.codecool.characterhandlerservice.model.Inventory;
import com.codecool.characterhandlerservice.model.Item;
import com.codecool.characterhandlerservice.repository.CharacterRepository;
import com.codecool.characterhandlerservice.service.InventoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityNotFoundException;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class InventoryServiceTest {

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private CharacterRepository characterRepository;

    @Test
    public void getInventoryThrowsErrorForBadId(){
        Assertions.assertThrows(EntityNotFoundException.class, () ->inventoryService.getInventoryByCharacterId(1L));
    }

    @Test
    void getInventoryIsNotNull(){

        Inventory characterInventory= Inventory.builder().build();
        GameCharacter gameCharacter= GameCharacter.builder().characterInventory(characterInventory).build();
        characterRepository.save(gameCharacter);

        Inventory inventory = inventoryService.getInventoryByCharacterId(1L);

        assertThat(inventory).isNotNull();
    }

}
