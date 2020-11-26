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
public class Statistics {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(mappedBy = "characterStatistics")
    private GameCharacter gameCharacter;

    private int problemSolving;
    private int design;
    private int algorithm;
    private int cleanCode;
    private int testing;
    private int energyLevel;
    private int motivation;


}
