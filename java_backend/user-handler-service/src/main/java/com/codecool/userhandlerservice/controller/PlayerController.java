package com.codecool.userhandlerservice.controller;

import com.codecool.userhandlerservice.model.Player;
import com.codecool.userhandlerservice.model.UserCredentials;
import com.codecool.userhandlerservice.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/{username}")
    public Optional<Player> getStudentByUsername(@PathVariable("username") String username) {
        return playerService.getPlayerByUsername(username);
    }

    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserCredentials student) {
        playerService.register(student.getUsername(), student.getPassword());
        return ResponseEntity.status(HttpStatus.CREATED).body(student.getUsername());
    }

}
