package com.codecool.characterhandlerservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Equipment {

    @Id
    @GeneratedValue
    private Long id;

    @ToString.Exclude
    @OneToOne(cascade = {CascadeType.PERSIST})
    @EqualsAndHashCode.Exclude
    private Item language;

    @ToString.Exclude
    @OneToOne(cascade = {CascadeType.PERSIST})
    @EqualsAndHashCode.Exclude
    private Item idea;

    @ToString.Exclude
    @OneToOne(cascade = {CascadeType.PERSIST})
    @EqualsAndHashCode.Exclude
    private Item framework;

    @ToString.Exclude
    @OneToOne(cascade = {CascadeType.PERSIST})
    @EqualsAndHashCode.Exclude
    private Item computer;

    @ToString.Exclude
    @OneToOne(cascade = {CascadeType.PERSIST})
    @EqualsAndHashCode.Exclude
    private Item accessory;

    @JsonBackReference
    @OneToOne(mappedBy = "characterEquipment")
    private GameCharacter gameCharacter;

}
