package com.codecool.shophandlerservice.service;

import com.codecool.shophandlerservice.entity.Item;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ItemServiceCaller {

    private final RestTemplate restTemplate;

    public ItemServiceCaller(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        System.out.println(getItem(5));
    }

    private final String itemHandlerUrl="http://item-handler-service/1";

    public Item getItem(Integer playerLevel){
        return restTemplate.getForEntity("http://localhost:8071/"+playerLevel, Item.class).getBody();
    }


}
