package com.codecool.shophandlerservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Item {

    @GeneratedValue
    @Id
    private Long id;
    private String name;

    private String equipmentSlot;

    private Long itemLevel;
    private String rarity;

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

    private Long characterId;

}
