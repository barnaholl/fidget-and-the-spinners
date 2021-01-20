package com.codecool.characterhandlerservice.service;

import com.codecool.characterhandlerservice.model.Equipment;
import com.codecool.characterhandlerservice.model.GameCharacter;
import com.codecool.characterhandlerservice.model.Item;
import com.codecool.characterhandlerservice.repository.CharacterRepository;
import com.codecool.characterhandlerservice.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class EquipmentService {

    private final CharacterRepository characterRepository;

    private final ItemRepository itemRepository;

    public Equipment getNewEquipment() {
        return Equipment.builder().build();
    }

    public Equipment getEquipmentByCharacterId(Long characterId){
        GameCharacter gameCharacter=characterRepository.findById(characterId).orElseThrow(EntityNotFoundException::new);
        Equipment equipment=gameCharacter.getCharacterEquipment();
        return equipment;
    }

    public void updateEquipmentByCharacterId(Long characterId,Equipment newEquipment){
        //TODO:Refactor(reflection,validation)

        GameCharacter gameCharacter=characterRepository.findById(characterId).orElseThrow(EntityNotFoundException::new);

        Equipment equipment=gameCharacter.getCharacterEquipment();

        Item newFramework=newEquipment.getFramework();
        itemRepository.save(newFramework);
        equipment.setFramework(newFramework);

        Item newLanguage=newEquipment.getLanguage();
        itemRepository.save(newLanguage);
        equipment.setLanguage(newLanguage);

        Item newIdea=newEquipment.getIdea();
        itemRepository.save(newIdea);
        equipment.setIdea(newIdea);

        Item newComputer=newEquipment.getComputer();
        itemRepository.save(newComputer);
        equipment.setComputer(newComputer);

        Item newAccessory=newEquipment.getAccessory();
        itemRepository.save(newAccessory);
        equipment.setAccessory(newAccessory);

        characterRepository.save(gameCharacter);

    }
}
