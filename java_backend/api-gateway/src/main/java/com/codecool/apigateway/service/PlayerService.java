package com.codecool.apigateway.service;

import com.codecool.apigateway.model.Player;
import com.codecool.apigateway.model.UserCredentials;
import com.codecool.apigateway.security.UserDetailsServiceImpl;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final RestTemplate restTemplate=new RestTemplate();
    private final UserDetailsServiceImpl userDetailsService;

    @Value("${user.handler.service.url}")
    private String userHandlerBaseUrl;

    @Value("${character.handler.service.url}")
    private String characterHandlerBaseUrl;

    public Player findUserById(Long id) {
        return restTemplate.getForEntity(userHandlerBaseUrl + "id?id=" + id, Player.class).getBody();
    }

    public Player findByUsername(String username) {
        return restTemplate.getForEntity(userHandlerBaseUrl + "player?username=" + username, Player.class).getBody();
    }

    public Player findByEmail(String email) {
        return restTemplate.getForEntity(userHandlerBaseUrl + "email?email=" + email, Player.class).getBody();
    }

    public List<Player> findAllPlayers() {
        PlayerList response = restTemplate.getForObject(userHandlerBaseUrl + "all", PlayerList.class);
        assert response != null;
        return response.getPlayers();
    }

    public void registerNewPlayerData(UserCredentials player) {
        restTemplate.postForEntity(userHandlerBaseUrl + "register", player, String.class);
    }

    public void handlePlayerCharacter(UserCredentials player) {
        HashMap<String, String> pathVariables = new HashMap<>();
        pathVariables.put("userId", player.getId().toString());
        pathVariables.put("username", player.getUsername());

        restTemplate.postForEntity(characterHandlerBaseUrl + "character/first",
                "", String.class, pathVariables);
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PlayerList {
        private List<Player> players;
    }

    public Long getUserIdByUsername(String username) {
        return userDetailsService.getPlayerIdByUsername(username);
    }

}
