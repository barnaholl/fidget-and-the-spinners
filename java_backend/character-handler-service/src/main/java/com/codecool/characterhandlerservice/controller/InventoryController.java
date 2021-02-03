package com.codecool.characterhandlerservice.controller;

import com.codecool.characterhandlerservice.model.Inventory;
import com.codecool.characterhandlerservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/inventory")
@Slf4j
public class InventoryController {
    private final InventoryService inventoryService;

    @GetMapping("/")
    public ResponseEntity<Inventory> getInventoryByCharacterId(@RequestParam("characterId") Long characterId ){
        return ResponseEntity.ok(inventoryService.getInventoryByCharacterId(characterId));
    }

    @PutMapping("/")
    public ResponseEntity<String> updateInventoryByCharacterId(@RequestParam("characterId") Long characterId, @RequestBody Inventory inventory){
        inventoryService.updateInventoryByCharacterId(characterId, inventory);
        return ResponseEntity.ok("Inventory updated for character with id: "+characterId);
    }
}
