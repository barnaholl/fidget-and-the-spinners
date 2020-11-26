package com.codecool.characterhandlerservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/character")
@Slf4j
public class CharacterController {

    private final CharacterService characterService;

    @GetMapping("")
    public ResponseEntity<Character> getCharacter(@RequestBody Long userId) {
        return ResponseEntity.ok(characterService.getCharacterByUserId(userId));
    }

}
