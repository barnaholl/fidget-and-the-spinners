package com.codecool.shophandlerservice.controller;

import com.codecool.shophandlerservice.entity.Item;
import com.codecool.shophandlerservice.service.ShopService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping("/addItemToShop")
    public ResponseEntity<String> addItemToShopByCharacterIdAndCharacterLevel(@RequestParam("characterId") Long characterId, @RequestParam("characterLevel") Long characterLevel){
        if(characterId<=0||characterLevel<=0){
            return new ResponseEntity("Params must be positive values",HttpStatus.BAD_REQUEST);
        }
        shopService.addItemToShopByCharacterIdAndCharacterLevel(characterId,characterLevel);
        return new ResponseEntity("A level "+characterLevel+ " item is successfully added to the shop of character with id: "+characterId, HttpStatus.OK);
    }

    @GetMapping("/getItemsByCharacterId")
    public List<Item> getItemsByCharacterId(@RequestParam("characterId") Long characterId){
        return shopService.getItemsByCharacterId(characterId);
    }

    @PostMapping("/addMultipleItemsToShop")
    public void addMultipleItemsToShopByCharacterIdAndCharacterLevel(@RequestParam("characterId") Long characterId,@RequestParam("characterLevel") Long characterLevel,@RequestParam("numberOfItems") Long numberOfItems){
        shopService.addMultipleItemsToShopByCharacterIdAndCharacterLevel(characterId,characterLevel,numberOfItems);
    }

    @PutMapping("/refreshShop")
    public void refreshItemsByCharacterId(@RequestParam("characterId") Long characterId,@RequestParam("characterLevel") Long characterLevel) throws Exception {
        shopService.refreshItemsByCharacterId(characterId, characterLevel);
    }

    @GetMapping("/buyItem")
    public Item buyItem(@RequestParam("id") Long id){
        return shopService.pollItemById(id);
    }


}
