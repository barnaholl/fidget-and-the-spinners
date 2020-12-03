package com.codecool.shophandlerservice.controller;

import com.codecool.shophandlerservice.service.ShopService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping("/{characterId}/{characterLevel}")
    public void getNewItemByCharacterIdAndCharacterLevel(@PathVariable("characterId") Long characterId,@PathVariable("characterLevel") Long characterLevel){
        shopService.getNewItemByCharacterIdAndCharacterLevel(characterId,characterLevel);
    }
}
