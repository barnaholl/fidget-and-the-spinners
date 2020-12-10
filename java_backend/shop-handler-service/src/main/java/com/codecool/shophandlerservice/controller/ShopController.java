package com.codecool.shophandlerservice.controller;

import com.codecool.shophandlerservice.entity.Item;
import com.codecool.shophandlerservice.service.ShopService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping("/newItemToShop")
    public void getNewItemByCharacterIdAndCharacterLevel(@RequestParam("characterId") Long characterId,@RequestParam("characterLevel") Long characterLevel){
        shopService.getNewItemByCharacterIdAndCharacterLevel(characterId,characterLevel);
    }

    @GetMapping("/{characterId}")
    public List<Item> getItemsByCharacterId(@PathVariable("characterId") Long characterId){
        return shopService.getItemsByCharacterId(characterId);
    }

}
