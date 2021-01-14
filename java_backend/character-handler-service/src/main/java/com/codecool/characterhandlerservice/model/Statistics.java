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
public class Statistics {

    @Id
    @GeneratedValue
    private Long id;

    @JsonBackReference
    @OneToOne(mappedBy = "characterStatistics")
    private GameCharacter gameCharacter;

    private int problemSolving;
    private int design;
    private int algorithm;
    private int cleanCode;
    private int testing;
    private int motivation;
    private int fastCoding;
    private int debugChance;


}
