package com.codecool.characterhandlerservice.service;

import com.codecool.characterhandlerservice.model.GameCharacter;
import com.codecool.characterhandlerservice.model.Inventory;
import com.codecool.characterhandlerservice.repository.CharacterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final CharacterRepository characterRepository;

    public Inventory getNewInventory() {
        return Inventory.builder().build();
    }

    public Inventory getInventoryByCharacterId(Long characterId){
        GameCharacter gameCharacter= characterRepository.findById(characterId).orElseThrow(()-> new EntityNotFoundException());
        return gameCharacter.getCharacterInventory();
    }

    public void updateInventoryByCharacterId(Long characterId,Inventory newInventory){
        GameCharacter gameCharacter = characterRepository.findById(characterId)
                .orElseThrow(()->new EntityNotFoundException());

        gameCharacter.setCharacterInventory(newInventory);

        characterRepository.save(gameCharacter);
    }
}
