package com.codecool.characterhandlerservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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

    @OneToOne(mappedBy = "character")
    private Set<Equipment> characterEquipment;

    @OneToOne(mappedBy = "character")
    private List<Item> characterInventory;



}
