package com.codecool.shophandlerservice.service;

import com.codecool.shophandlerservice.entity.Item;
import com.codecool.shophandlerservice.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {
    private final ItemRepository itemRepository;

    private final ItemServiceCaller itemServiceCaller;

    public ShopService(ItemRepository itemRepository, ItemServiceCaller itemServiceCaller) {
        this.itemRepository = itemRepository;
        this.itemServiceCaller = itemServiceCaller;
    }

    public void getNewItemByCharacterIdAndCharacterLevel(Long characterId, Long characterLevel){
        Item item=itemServiceCaller.getItem(characterLevel);
        item.setCharacterId(characterId);
        itemRepository.save(item);
    }

    public List<Item> getItemsByCharacterId(Long characterId){
        return itemRepository.findAllByCharacterId(characterId);
    }
}
