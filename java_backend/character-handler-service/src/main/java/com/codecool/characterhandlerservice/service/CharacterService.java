package com.codecool.characterhandlerservice.service;

import com.codecool.characterhandlerservice.model.*;
import com.codecool.characterhandlerservice.repository.CharacterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import java.util.*;

@Service
@RequiredArgsConstructor
public class CharacterService {

    private final CharacterRepository characterRepository;
    private final StatisticsService statisticsService;
    private final InventoryService inventoryService;
    private final EquipmentService equipmentService;

    private static final Long AMOUNT_OF_STARTER_CURRENCY = (long)  0;
    private static final Long AMOUNT_OF_STARTER_EXPERIENCE = (long) 0;
    private static final int CHARACTER_STARTER_ENERGY_LEVEL = 100;
    private static final int CHARACTER_STARTER_LEVEL = 1;

    public GameCharacter getCharacterByUserId(Long userId) {
        return characterRepository
                .getCharacterByUserId(userId)
                .orElseThrow(() -> new EntityNotFoundException("Character not found by user id: "+userId));
    }

    public GameCharacter saveNewCharacter(Long userId, String characterName, String characterClass) {
        if(userId<=0){
            throw new IllegalArgumentException("UserId("+userId+") has to be a positive number");
        }
        GameCharacter newGameCharacter = initializeNewCharacter(userId, characterName, convertStringToCharacterClass(characterClass));
        return characterRepository.save(newGameCharacter);
    }

    private Inventory initializeNewInventory() {
        return inventoryService.getNewInventory();
    }

    private Equipment initializeNewEquipment() {
        return equipmentService.getNewEquipment();
    }

    private Statistics initializeStarterStatistics(CharacterClass characterClass) {
        return statisticsService.getStarterStatistics(characterClass);
    }

    private GameCharacter initializeNewCharacter(Long userId, String characterName, CharacterClass characterClass) {
        return GameCharacter.builder()
                .characterClass(characterClass)
                .characterStatistics(initializeStarterStatistics(characterClass))
                .characterEquipment(initializeNewEquipment())
                .characterInventory(initializeNewInventory())
                .characterCurrency(AMOUNT_OF_STARTER_CURRENCY)
                .characterExperience(AMOUNT_OF_STARTER_EXPERIENCE)
                .characterLevel(CHARACTER_STARTER_LEVEL)
                .energyLevel(CHARACTER_STARTER_ENERGY_LEVEL)
                .characterName(characterName)
                .userId(userId)
                .build();
    }

    private CharacterClass convertStringToCharacterClass(String characterClass) {
        for(CharacterClass enumClass : CharacterClass.values()){
            if(enumClass.name().equals(characterClass)){
                return enumClass;
            }
        }
        throw new NoResultException("CharacterClass: "+characterClass+" is not exist, try one of these: "+ Arrays.toString(CharacterClass.values()));
    }

    public GameCharacter updateCharacter(GameCharacter gameCharacter) {
        return characterRepository.save(gameCharacter);
    }

    public void deleteCharacter(Long characterId) {
        characterRepository.findById(characterId).orElseThrow(EntityNotFoundException::new);
        characterRepository.deleteById(characterId);
    }

    public Map<Long,Long> getAllCharacterIdAndLevel() {
        Map<Long,Long> result=new HashMap<>();
        List<GameCharacter> gameCharacters=characterRepository.findAll();
        if(gameCharacters.size()==0){
            throw new NoResultException("Character repository is empty");
        }
        for (GameCharacter gameCharacter:gameCharacters) {
            result.put(gameCharacter.getId(), (long) gameCharacter.getCharacterLevel());
        }
        return result;
    }

    public void checkIfPlayerHasCharacter(Long playerId) {
        boolean isCharacterPresent = characterRepository.getCharacterByUserId(playerId).isPresent();
        if(!isCharacterPresent) {
            characterRepository.save(GameCharacter.builder().build());
        }
    }
}
