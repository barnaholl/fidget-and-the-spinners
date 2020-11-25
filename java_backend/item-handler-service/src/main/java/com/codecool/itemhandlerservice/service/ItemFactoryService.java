package com.codecool.itemhandlerservice.service;

import com.codecool.itemhandlerservice.repository.ItemRepository;

public class ItemFactoryService {
    private final ItemRepository itemRepository;

    public ItemFactoryService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
}
