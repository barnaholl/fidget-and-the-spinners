package com.codecool.userhandlerservice.service;

import com.codecool.userhandlerservice.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
@RequiredArgsConstructor
public class InitialPlayerCreator {

    private final PlayerService userService;

    @Bean
    public CommandLineRunner createUsers() {
        return args -> {
            userService.register("admin", "admin", Set.of(Role.USER, Role.ADMIN));
            userService.register("user", "user");
        };
    }
}
