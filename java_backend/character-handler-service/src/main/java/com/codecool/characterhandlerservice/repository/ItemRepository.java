package com.codecool.characterhandlerservice.repository;

import com.codecool.characterhandlerservice.model.Inventory;
import com.codecool.characterhandlerservice.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemRepository extends JpaRepository<Item,Long> {
    void deleteAllByInventory(Inventory inventory);
}
