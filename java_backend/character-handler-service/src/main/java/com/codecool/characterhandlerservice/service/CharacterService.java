package com.codecool.characterhandlerservice.service;

import com.codecool.characterhandlerservice.model.Equipment;
import com.codecool.characterhandlerservice.model.GameCharacter;
import com.codecool.characterhandlerservice.model.Inventory;
import com.codecool.characterhandlerservice.model.Statistics;
import com.codecool.characterhandlerservice.repository.CharacterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CharacterService {

    private final CharacterRepository characterRepository;
    private final StatisticsService statisticsService;
    private final InventoryService inventoryService;
    private final EquipmentService equipmentService;

    private static final Long AMOUNT_OF_STARTER_CURRENCY = (long) 1000;
    private static final Long AMOUNT_OF_STARTER_EXPERIENCE = (long) 0;
    private static final int CHARACTER_STARTER_ENERGY_LEVEL = 1;
    private static final int CHARACTER_STARTER_LEVEL = 1;

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

    private Statistics initializeStarterStatistics() {
        return statisticsService.getStarterStatistics();
    }

    private GameCharacter initializeNewCharacter(Long userId, String characterName) {
        return GameCharacter.builder()
                .characterStatistics(initializeStarterStatistics())
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

    public GameCharacter updateCharacter(GameCharacter gameCharacter) {
        return characterRepository.save(gameCharacter);
    }

    public boolean deleteCharacter(GameCharacter gameCharacter) {
        characterRepository.delete(gameCharacter);
        return characterRepository.getCharacterByUserId(gameCharacter.getUserId()).isEmpty();
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
}
