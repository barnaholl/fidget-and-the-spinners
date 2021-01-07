package com.codecool.characterhandlerservice.controller;

import com.codecool.characterhandlerservice.model.GameCharacter;
import com.codecool.characterhandlerservice.service.CharacterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/character")
@Slf4j
public class CharacterController {

    private final CharacterService characterService;

    @GetMapping("")
    public ResponseEntity<GameCharacter> getCharacter(@RequestParam("userId") Long userId) {
        return ResponseEntity.ok(characterService.getCharacterByUserId(userId));
    }

    @PostMapping("")
    public ResponseEntity<GameCharacter> saveNewCharacter(@RequestParam("userId") Long userId, @RequestParam("characterName") String characterName) {
        return ResponseEntity.ok(characterService.saveNewCharacter(userId, characterName));
    }

    @PutMapping("")
    public ResponseEntity<GameCharacter> updateCharacter(@RequestBody GameCharacter gameCharacter) {
        return ResponseEntity.ok(characterService.updateCharacter(gameCharacter));
    }

    @DeleteMapping("")
    public ResponseEntity<Boolean> deleteCharacter(@RequestBody GameCharacter gameCharacter) {
        return ResponseEntity.ok(characterService.deleteCharacter(gameCharacter));
    }

    @GetMapping("/characterLevels")
    public ResponseEntity<Map<Long,Long>> getAllCharacterIdAndLevel() {
        return ResponseEntity.ok(characterService.getAllCharacterIdAndLevel());
    }
}
