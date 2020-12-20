package com.codecool.shophandlerservice.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class ScheduledOperations {

    private final ShopService shopService;

    private final CharacterServiceCaller characterServiceCaller;

    public ScheduledOperations(ShopService shopService, CharacterServiceCaller characterServiceCaller) {
        this.shopService = shopService;
        this.characterServiceCaller = characterServiceCaller;
    }

    //@Scheduled(cron = "0 0 0 * * ?") //Every day at "0:00"
    //@Scheduled(cron = "0 0 * * * ?") //Every hour
    @Scheduled(cron = "0 */5 * * * ?") //Every 5 minute
    //@Scheduled(cron = "0 * * * * ?") //Every minute
    private void refreshShops() throws Exception {
        Map<String,Integer> characterLevels=characterServiceCaller.getCharacterLevels();
        for (String key:characterLevels.keySet()) {
            shopService.refreshItemsByCharacterId(Long.valueOf(key),(long)characterLevels.get(key));
        }

    }
}
