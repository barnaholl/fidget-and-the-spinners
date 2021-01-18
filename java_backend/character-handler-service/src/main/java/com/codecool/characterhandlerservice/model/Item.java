package com.codecool.characterhandlerservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Item {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne(cascade = {CascadeType.ALL})
    private Equipment equipment;

    @JsonBackReference
    @ManyToOne(cascade = {CascadeType.ALL})
    private Inventory inventory;

    @Enumerated(EnumType.STRING)
    private EquipmentSlot equipmentSlot;

    @Enumerated(EnumType.STRING)
    private Rarity rarity;

    private Long itemLevel;

    private Long problemSolving;
    private Long design;
    private Long algorithmization;
    private Long cleanCode;
    private Long testing;

    private Long sellPrice;
    private Long buyPrice;
}
