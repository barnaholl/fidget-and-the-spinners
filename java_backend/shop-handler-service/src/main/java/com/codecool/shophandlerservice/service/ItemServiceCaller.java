package com.codecool.shophandlerservice.service;

import com.codecool.shophandlerservice.entity.Item;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ItemServiceCaller {

    private final RestTemplate restTemplate;

    public ItemServiceCaller(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${item.handler.service.url}")
    private String itemHandlerUrl;


    public Item getItem(Long playerLevel){
        return restTemplate.getForEntity(itemHandlerUrl+"/item?playerLevel="+playerLevel, Item.class).getBody();
    }

    public Item[] getItems(Long playerLevel,Long numberOfItems){
        return restTemplate.getForEntity(itemHandlerUrl+"items?playerLevel="+playerLevel+"&numberOfItems="+numberOfItems, Item[].class).getBody();
    }

}
