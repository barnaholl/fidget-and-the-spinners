package com.codecool.characterhandlerservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.inject.internal.cglib.core.$ClassNameReader;
import lombok.*;

import javax.persistence.*;
import java.util.List;

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

    @OneToOne(cascade = {CascadeType.ALL})
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Equipment characterEquipment;

    @OneToOne(cascade = {CascadeType.ALL})
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Inventory characterInventory;

    @OneToOne(cascade = {CascadeType.ALL})
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Statistics characterStatistics;
}
