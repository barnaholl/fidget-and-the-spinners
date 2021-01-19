package com.codecool.characterhandlerservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @JsonManagedReference
    @Singular
    @OneToMany(mappedBy = "inventory", cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Item> inventoryItems;


}
