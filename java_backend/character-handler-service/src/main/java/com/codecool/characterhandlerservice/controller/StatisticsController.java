package com.codecool.characterhandlerservice.controller;

import com.codecool.characterhandlerservice.model.Statistics;
import com.codecool.characterhandlerservice.service.StatisticsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/statistics")
@Slf4j
public class StatisticsController {

    private final StatisticsService statisticsService;

    @GetMapping("/")
    public Statistics getStatistics(@RequestParam("characterId") Long characterId){
        return statisticsService.getStatisticsByCharacterId(characterId);
    }
}
