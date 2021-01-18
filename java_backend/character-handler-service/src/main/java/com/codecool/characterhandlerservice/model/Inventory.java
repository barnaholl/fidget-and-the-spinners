package com.codecool.characterhandlerservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Inventory {

    @Id
    @GeneratedValue
    private Long id;

    @JsonBackReference
    @OneToOne(mappedBy = "characterInventory")
    private GameCharacter gameCharacter;

    @Singular
    @OneToMany(mappedBy = "equipment", cascade = {CascadeType.PERSIST})
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Item> InventoryItems;

}
