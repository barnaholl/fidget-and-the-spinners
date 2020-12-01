package com.codecool.userhandlerservice.controller;

import com.codecool.userhandlerservice.model.Player;
import com.codecool.userhandlerservice.model.UserCredentials;
import com.codecool.userhandlerservice.repository.PlayerRepository;
import com.codecool.userhandlerservice.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService, PlayerRepository allPlayers) {
        this.playerService = playerService;
    }

    @GetMapping("/id")
    public Optional<Player> getPlayerById(@RequestParam("id") Long id) {
        return playerService.getPlayerById(id);
    }

    @GetMapping("/player")
    public Optional<Player> getPlayerByUsername(@RequestParam("username") String username) {
        return playerService.getPlayerByUsername(username);
    }

    @GetMapping("/email")
    public Optional<Player> getPlayerByEmail(@RequestParam("email") String email) {
        return playerService.getPlayerByEmail(email);
    }

    @GetMapping("/all")
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserCredentials student) {
        playerService.registerData(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student.getUsername());
    }

}
