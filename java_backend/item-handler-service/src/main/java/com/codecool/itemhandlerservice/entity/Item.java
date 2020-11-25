package com.codecool.itemhandlerservice.entity;

import com.codecool.itemhandlerservice.model.Rarity;
import com.codecool.itemhandlerservice.model.Slot;
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

    private Slot slot;

    private Long itemLevel;
    private Rarity rarity;

    private Long problemSolving;
    private Long frontEnd;
    private Long backEnd;
    private Long cleanCode;
    private Long testing;

    private Long sellPrice;
    private Long buyPrice;
}
