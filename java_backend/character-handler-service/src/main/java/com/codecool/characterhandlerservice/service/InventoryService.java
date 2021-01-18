package com.codecool.characterhandlerservice.service;

import com.codecool.characterhandlerservice.model.GameCharacter;
import com.codecool.characterhandlerservice.model.Inventory;
import com.codecool.characterhandlerservice.model.Item;
import com.codecool.characterhandlerservice.repository.CharacterRepository;
import com.codecool.characterhandlerservice.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional //to solve deleteByInventory
public class InventoryService {

    private final CharacterRepository characterRepository;

    private final ItemRepository itemRepository;

    public Inventory getNewInventory() {
        return Inventory.builder().build();
    }

    public Inventory getInventoryByCharacterId(Long characterId){
        GameCharacter gameCharacter= characterRepository.findById(characterId).orElseThrow(EntityNotFoundException::new);
        return gameCharacter.getCharacterInventory();
    }

    public void updateInventoryByCharacterId(Long characterId,Inventory newInventory){
        GameCharacter gameCharacter = characterRepository.findById(characterId)
                .orElseThrow(EntityNotFoundException::new);

        Inventory inventory=gameCharacter.getCharacterInventory();
        itemRepository.deleteAllByInventory(inventory);

        List<Item> newItems= new ArrayList<>();

        for(Item newItem:newInventory.getInventoryItems()){
            newItem.setInventory(inventory);
            itemRepository.save(newItem);
            newItems.add(newItem);
        }
        inventory.setInventoryItems(newItems);

        characterRepository.save(gameCharacter);
    }
}
