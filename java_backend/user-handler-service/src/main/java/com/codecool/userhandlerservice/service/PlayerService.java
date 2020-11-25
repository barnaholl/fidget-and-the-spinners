package com.codecool.userhandlerservice.service;

import com.codecool.userhandlerservice.model.Player;
import com.codecool.userhandlerservice.model.Role;
import com.codecool.userhandlerservice.model.UserCredentials;
import com.codecool.userhandlerservice.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository allPlayers;
    private final PasswordEncoder encoder;

    public Player register(String username, String password, Set<Role> roles) {
        return allPlayers.save(
                Player.builder()
                        .userName(username)
                        .hashedPassword(encoder.encode(password))
                        .roles(roles)
                        .build()
        );
    }

    public Player register(String username, String password) {
        return allPlayers.save(
                Player.builder()
                        .userName(username)
                        .hashedPassword(encoder.encode(password))
                        .role(Role.USER)
                        .build()
        );
    }

    public Player register(UserCredentials userCredentials) {
        return register(userCredentials.getUsername(), userCredentials.getPassword());
    }

}
