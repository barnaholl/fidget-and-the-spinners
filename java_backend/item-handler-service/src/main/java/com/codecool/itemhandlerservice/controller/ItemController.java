package com.codecool.itemhandlerservice.controller;

import com.codecool.itemhandlerservice.entity.Item;
import com.codecool.itemhandlerservice.service.ItemFactoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {
    private final ItemFactoryService itemFactoryService;

    public ItemController(ItemFactoryService itemFactoryService) {
        this.itemFactoryService = itemFactoryService;
    }

    @GetMapping("/item")
    public Item getItemByLevel(@RequestParam("playerLevel") Long playerLevel){
        return itemFactoryService.getRandomItemByPlayerLevel(playerLevel);
    }

    @GetMapping("/items")
    public List<Item> getMultipleItemsByLevel(@RequestParam("playerLevel") Long playerLevel, @RequestParam("numberOfItems") int numberOfItems){
        return itemFactoryService.getMultipleRandomItemsByPlayerLevel(playerLevel,numberOfItems);
    }

}
