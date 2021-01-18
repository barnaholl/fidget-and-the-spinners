package com.codecool.characterhandlerservice.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class GameCharacter {

    @Id
    @GeneratedValue
    private Long id;

    private Long userId;

    private String characterName;
    private int characterLevel;
    private int energyLevel;
    private Long characterExperience;
    private Long characterCurrency;

    private CharacterClass characterClass;

    @JsonManagedReference
    @OneToOne(cascade = {CascadeType.PERSIST})
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Inventory characterInventory;


    @JsonManagedReference
    @OneToOne(cascade = {CascadeType.PERSIST})
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Equipment characterEquipment;


    @JsonManagedReference
    @OneToOne(cascade = {CascadeType.ALL})
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Statistics characterStatistics;


}
