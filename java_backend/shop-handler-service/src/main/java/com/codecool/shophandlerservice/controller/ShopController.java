package com.codecool.shophandlerservice.controller;

import com.codecool.shophandlerservice.entity.Item;
import com.codecool.shophandlerservice.service.ShopService;
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
            return ResponseEntity.badRequest().body("Params must be positive values");
        }
        shopService.addItemToShopByCharacterIdAndCharacterLevel(characterId,characterLevel);
        return ResponseEntity.ok("A level "+characterLevel+ " item is successfully added to the shop of character with id: "+characterId);    }

    @GetMapping("/getItemsByCharacterId")
    public ResponseEntity<List<Item>> getItemsByCharacterId(@RequestParam("characterId") Long characterId){
        return ResponseEntity.ok(shopService.getItemsByCharacterId(characterId));
    }

    @PostMapping("/addMultipleItemsToShop")
    public ResponseEntity<String> addMultipleItemsToShopByCharacterIdAndCharacterLevel(@RequestParam("characterId") Long characterId,@RequestParam("characterLevel") Long characterLevel,@RequestParam("numberOfItems") Long numberOfItems){
        if(characterId<=0||characterLevel<=0||numberOfItems<=0){
            return ResponseEntity.badRequest().body("Params must be positive values");
        }
        shopService.addMultipleItemsToShopByCharacterIdAndCharacterLevel(characterId,characterLevel,numberOfItems);
        return ResponseEntity.ok(numberOfItems+" level "+characterLevel+" items are successfully added to the shop of character with id: "+characterId);
    }

    @PutMapping("/refreshShop")
    public ResponseEntity<String> refreshItemsByCharacterId(@RequestParam("characterId") Long characterId,@RequestParam("characterLevel") Long characterLevel) throws Exception {
        if(characterId<=0||characterLevel<=0){
            return ResponseEntity.badRequest().body("Params must be positive values");
        }
        shopService.refreshItemsByCharacterId(characterId, characterLevel);

        return ResponseEntity.ok().body("Items of character with id: "+characterId+" is refreshed");
    }

    @GetMapping("/buyItem")
    public ResponseEntity<Item> buyItem(@RequestParam("id") Long id){
        return ResponseEntity.ok(shopService.pollItemById(id));
    }


}
