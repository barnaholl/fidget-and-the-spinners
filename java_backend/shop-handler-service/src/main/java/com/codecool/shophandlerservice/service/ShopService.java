package com.codecool.shophandlerservice.service;

import com.codecool.shophandlerservice.entity.Item;
import com.codecool.shophandlerservice.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopService {
    private final ItemRepository itemRepository;

    private final ItemServiceCaller itemServiceCaller;

    public ShopService(ItemRepository itemRepository, ItemServiceCaller itemServiceCaller) {
        this.itemRepository = itemRepository;
        this.itemServiceCaller = itemServiceCaller;
    }

    public void addItemToShopByCharacterIdAndCharacterLevel(Long characterId, Long characterLevel){
        if(characterId<=0||characterLevel<=0){
            throw new IllegalArgumentException("Params must be positive values");
        }
        Item item=itemServiceCaller.getItem(characterLevel);
        item.setCharacterId(characterId);
        itemRepository.save(item);

    }

    public List<Item> getItemsByCharacterId(Long characterId){
        return itemRepository.findAllByCharacterId(characterId);
    }

    public void addMultipleItemsToShopByCharacterIdAndCharacterLevel(Long characterId, Long characterLevel,Long numberOfItems){

        if(characterId<=0||characterLevel<=0||numberOfItems<=0){
            throw new IllegalArgumentException("Params must be positive values");
        }

        List<Item> items=new ArrayList<>();
        for (int i = 0; i < numberOfItems; i++) {
            Item item=itemServiceCaller.getItem(characterLevel);
            item.setCharacterId(characterId);
            items.add(item);
        }

        itemRepository.saveAll(items);

    }
}
