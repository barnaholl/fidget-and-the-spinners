package com.codecool.itemhandlerservice.repository;

import com.codecool.itemhandlerservice.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
}
