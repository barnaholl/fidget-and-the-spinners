package com.codecool.shophandlerservice.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
public class ScheduledOperations {

    //@Scheduled(cron = "0 0 0 * * ?") //Every day at "0:00"
    //@Scheduled(cron = "0 0 * * * ?") //Every hour
    @Scheduled(cron = "0 * * * * ?") //Every minute
    private void refreshShops(){
        System.out.println("Refresh");
    }
}
