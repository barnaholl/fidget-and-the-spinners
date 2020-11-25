package com.codecool.characterhandlerservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Equipment {

    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnore
    @Singular
    @OneToMany(mappedBy = "equipment", cascade = {CascadeType.PERSIST})
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Item> equipmentItems;

    @OneToOne(mappedBy = "statistics")
    private Character character;

}
