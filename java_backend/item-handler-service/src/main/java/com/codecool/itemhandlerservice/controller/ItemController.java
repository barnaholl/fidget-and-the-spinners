package com.codecool.itemhandlerservice.controller;

import com.codecool.itemhandlerservice.entity.Item;
import com.codecool.itemhandlerservice.service.ItemFactoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
    private final ItemFactoryService itemFactoryService;

    public ItemController(ItemFactoryService itemFactoryService) {
        this.itemFactoryService = itemFactoryService;
    }

    @GetMapping("/{playerLevel}")
    public Item getItemByLevel(@PathVariable("playerLevel") Long playerLevel){
        return itemFactoryService.getRandomItem(playerLevel);
    }

}
