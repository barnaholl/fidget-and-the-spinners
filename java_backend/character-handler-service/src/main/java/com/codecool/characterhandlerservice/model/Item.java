package com.codecool.characterhandlerservice.model;

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
public class Item {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(cascade = {CascadeType.ALL})
    private Equipment equipment;

}
