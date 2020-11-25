package com.codecool.characterhandlerservice.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Character {

    @Id
    @GeneratedValue
    private Long id;

    private String characterName;
    private int characterLevel;
    private Long characterExperience;
    private Long characterCurrency;

    @OneToOne(cascade = {CascadeType.ALL})
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Item> characterEquipment;


    private List<Item> characterInventory;



}
