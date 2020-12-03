package com.codecool.shophandlerservice.controller;

import com.codecool.shophandlerservice.service.ShopService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }
}
