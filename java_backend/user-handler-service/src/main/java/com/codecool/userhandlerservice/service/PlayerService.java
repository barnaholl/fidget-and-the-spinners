package com.codecool.userhandlerservice.service;

import com.codecool.userhandlerservice.model.Player;
import com.codecool.userhandlerservice.model.Role;
import com.codecool.userhandlerservice.model.UserCredentials;
import com.codecool.userhandlerservice.repository.PlayerRepository;
import org.springframework.http.HttpMethod;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PlayerService {

    private final PlayerRepository allPlayers;
    private final PasswordEncoder encoder;

    public PlayerService(PlayerRepository allPlayers) {
        this.allPlayers = allPlayers;
        encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    }

    public Optional<Player> getPlayerById(Long id) {
        return allPlayers.findById(id);
    }

    public Optional<Player> getPlayerByUsername(String username) {
        return allPlayers.findByUserName(username);
    }

    public Optional<Player> getPlayerByEmail(String email) {return allPlayers.findByEmail(email); }

    public List<Player> getAllPlayers() {
        return allPlayers.findAllPlayers();
    }

    public Player register(String username, String password, Set<Role> roles, String email) {
        return allPlayers.save(
                Player.builder()
                        .userName(username)
                        .hashedPassword(encoder.encode(password))
                        .roles(roles)
                        .email(email)
                        .build()
        );
    }

    public Player register(String username, String password, String email) {
        return allPlayers.save(
                Player.builder()
                        .userName(username)
                        .hashedPassword(encoder.encode(password))
                        .role(Role.USER)
                        .email(email)
                        .build()
        );
    }

    public Player registerData(UserCredentials player) {
        return register(player.getUsername(), player.getPassword(), player.getEmail());
    }
}
