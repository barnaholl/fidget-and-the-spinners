package com.codecool.shophandlerservice.service;

import com.codecool.shophandlerservice.entity.Item;
import com.codecool.shophandlerservice.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopService {
    private final ItemRepository itemRepository;

    private final ItemServiceCaller itemServiceCaller;

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

        List<Item> items=Arrays.asList(itemServiceCaller.getItems(characterLevel,numberOfItems));

        for (Item item : items) {
            item.setCharacterId(characterId);
        }

        itemRepository.saveAll(items);

    }

    public void refreshItemsByCharacterId(Long characterId,Long characterLevel) throws Exception {
        if(characterId<=0||characterLevel<=0){
            throw new IllegalArgumentException("Params must be positive values");
        }

        List items=itemRepository.findAllByCharacterId(characterId);
        long numberOfItems=items.size();

        if(numberOfItems==0){
            throw new Exception("There is no item with that characterId");
        }

        itemRepository.deleteAll(items);

        addMultipleItemsToShopByCharacterIdAndCharacterLevel(characterId,characterLevel,numberOfItems);
    }

    public Item pollItemById(Long id){
        if(id<=0){
            throw new IllegalArgumentException("Id must be positive value");
        }

        Item item=itemRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        itemRepository.delete(item);
        return item;
    }

}
