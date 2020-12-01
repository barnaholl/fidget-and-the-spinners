package com.codecool.shophandlerservice.repository;

import com.codecool.shophandlerservice.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {

}
