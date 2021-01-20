package com.codecool.characterhandlerservice.service;

import com.codecool.characterhandlerservice.model.GameCharacter;
import com.codecool.characterhandlerservice.repository.CharacterRepository;
import com.codecool.characterhandlerservice.repository.ItemRepository;
import com.codecool.characterhandlerservice.utility.CharacterInventoryMother;
import com.codecool.characterhandlerservice.utility.CharacterMother;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import({InventoryService.class})
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class InventoryServiceTest {

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private InventoryService inventoryService;

    @Test
    public void getInventoryByCharacterIdTest() {
        GameCharacter gameCharacter = CharacterMother.getTesterCharacterWithEquipmentAndInventoryItems();
        Long savedId = characterRepository.save(gameCharacter).getId();

        assertThat(inventoryService.getInventoryByCharacterId(savedId)
                .equals(gameCharacter.getCharacterInventory()));
    }
}
