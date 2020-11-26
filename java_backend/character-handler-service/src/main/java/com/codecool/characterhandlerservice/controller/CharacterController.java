package com.codecool.characterhandlerservice.controller;

import com.codecool.characterhandlerservice.model.GameCharacter;
import com.codecool.characterhandlerservice.service.CharacterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/character")
@Slf4j
public class CharacterController {

    private final CharacterService characterService;

    @GetMapping("")
    public ResponseEntity<GameCharacter> getCharacter(@RequestBody Long userId) {
        return ResponseEntity.ok(characterService.getCharacterByUserId(userId));
    }

    @PostMapping("")
    public ResponseEntity<GameCharacter> saveCharacter(@RequestBody Long userId) {
        return ResponseEntity.ok(characterService.saveCharacter(userId));
    }

}
