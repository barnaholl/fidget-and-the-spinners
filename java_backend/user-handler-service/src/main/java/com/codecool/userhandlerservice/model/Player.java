package com.codecool.userhandlerservice.model;

import lombok.*;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name="players")
public class Player {

    @Id
    private String userName;

    @NotBlank
    private String hashedPassword;

    @ElementCollection
    @Singular
    @NotEmpty
    private Set<Role> roles;

}
