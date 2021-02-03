package com.codecool.characterhandlerservice.controller;

import com.codecool.characterhandlerservice.model.Equipment;
import com.codecool.characterhandlerservice.service.EquipmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/equipment")
@Slf4j
public class EquipmentController {

    private final EquipmentService equipmentService;

    @GetMapping("/")
    public ResponseEntity<Equipment> getEquipmentByCharacterId(@RequestParam("characterId") Long characterId){
        return ResponseEntity.ok(equipmentService.getEquipmentByCharacterId(characterId));
    }

    @PutMapping("/")
    public ResponseEntity<String> updateEquipmentByCharacterId(@RequestParam("characterId") Long characterId,@RequestBody Equipment equipment){
        equipmentService.updateEquipmentByCharacterId(characterId, equipment);
        return ResponseEntity.ok("Equipment updated at character with id: "+characterId);
    }
}
