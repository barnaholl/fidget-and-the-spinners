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

    /*@JsonIgnore
    @ToString.Exclude
    @Singular
    @OneToMany(mappedBy = "equipment", cascade = {CascadeType.PERSIST})
    @EqualsAndHashCode.Exclude
    private List<Item> equipmentItems;
    */

    //LANGUAGE,IDEA,FRAMEWORK,COMPUTER,ACCESSORY

    @JsonBackReference
    @OneToOne(mappedBy = "characterEquipment")
    private GameCharacter gameCharacter;

}
