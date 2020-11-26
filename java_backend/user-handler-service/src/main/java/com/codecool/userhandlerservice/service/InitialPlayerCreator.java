package com.codecool.userhandlerservice.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
public class InitialPlayerCreator {

    private final PlayerService userService;

    public InitialPlayerCreator(PlayerService userService) {
        this.userService = userService;
    }

    @Bean
    public CommandLineRunner createUsers() {
        return args -> {
            userService.register("admin", "admin", Set.of("USER", "ADMIN"));
            userService.register("gamer", "gamer");
        };
    }
}
