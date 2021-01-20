package com.codecool.itemhandlerservice.entity;

import com.codecool.itemhandlerservice.model.Rarity;
import com.codecool.itemhandlerservice.model.EquipmentSlot;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Item {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    private EquipmentSlot equipmentSlot;

    private Long itemLevel;
    private Rarity rarity;

    private Long problemSolving;
    private Long design;
    private Long algorithmization;
    private Long cleanCode;
    private Long testing;

    private Long motivation;

    private Long debugging;
    private Long codingSpeed;

    private Long sellPrice;
    private Long buyPrice;
}
