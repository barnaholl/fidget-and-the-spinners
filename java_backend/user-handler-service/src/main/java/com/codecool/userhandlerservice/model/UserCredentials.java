package com.codecool.userhandlerservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCredentials {
    private String username;
    private String password;
    private String email;

    public UserCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
