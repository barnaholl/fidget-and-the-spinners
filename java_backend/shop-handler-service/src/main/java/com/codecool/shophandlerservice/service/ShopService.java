package com.codecool.shophandlerservice.service;

import com.codecool.shophandlerservice.entity.Item;
import com.codecool.shophandlerservice.repository.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class ShopService {
    private final ItemRepository itemRepository;

    private final ItemServiceCaller itemServiceCaller;

    public ShopService(ItemRepository itemRepository, ItemServiceCaller itemServiceCaller) {
        this.itemRepository = itemRepository;
        this.itemServiceCaller = itemServiceCaller;
    }

    public void getNewItemByCharacterIdAndCharacterLevel(int characterId, int characterLevel){
        Item item=itemServiceCaller.getItem(characterLevel);
        item.setCharacterId((long) characterId);
        itemRepository.save(item);
    }
}
