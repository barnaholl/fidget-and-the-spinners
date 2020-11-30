package com.codecool.userhandlerservice.model;

import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="players")
public class Player {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String userName;

    @NotBlank
    private String hashedPassword;

    @ElementCollection
    @Singular
    @NotEmpty
    private Set<String> roles;

    @NotBlank
    @Email
    private String email;

}
