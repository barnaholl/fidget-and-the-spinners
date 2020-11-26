package com.codecool.characterhandlerservice.service;

import com.codecool.characterhandlerservice.model.Equipment;
import com.codecool.characterhandlerservice.model.GameCharacter;
import com.codecool.characterhandlerservice.model.Inventory;
import com.codecool.characterhandlerservice.model.Statistics;
import com.codecool.characterhandlerservice.repository.CharacterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class CharacterService {

    private final CharacterRepository characterRepository;
    private final StatisticsService statisticsService;
    private final InventoryService inventoryService;
    private final EquipmentService equipmentService;

    private static final Long AMOUNT_OF_STARTER_CURRENCY = (long)1000;

    public GameCharacter getCharacterByUserId(Long userId) {
        return characterRepository
                .getCharacterByUserId(userId)
                .orElseThrow(() -> new EntityNotFoundException("Character not found by user id"));
    }

    public GameCharacter saveNewCharacter(Long userId, String characterName) {
        GameCharacter newGameCharacter = initializeNewCharacter(userId, characterName);
        return characterRepository.save(newGameCharacter);
    }

    private Inventory initializeNewInventory() {
        return inventoryService.getNewInventory();
    }

    private Equipment initializeNewEquipment() {
        return equipmentService.getNewEquipment();
    }

    private GameCharacter initializeNewCharacter(Long userId, String characterName) {
        return GameCharacter.builder()
                .characterStatistics(statisticsService.getStarterStatistics())
                .characterCurrency(AMOUNT_OF_STARTER_CURRENCY)
                .characterExperience((long)0)
                .characterLevel(1)
                .characterName(characterName)
                .userId(userId)
                .energyLevel(1)
                .characterEquipment(initializeNewEquipment())
                .characterInventory(initializeNewInventory())
                .build();
    }

    public GameCharacter updateCharacter(GameCharacter gameCharacter) {
        return characterRepository.save(gameCharacter);
    }

    public boolean deleteCharacter(GameCharacter gameCharacter) {
        characterRepository.delete(gameCharacter);
        return characterRepository.getCharacterByUserId(gameCharacter.getUserId()).isEmpty();
    }
}
