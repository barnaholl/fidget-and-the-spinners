package com.codecool.characterhandlerservice.controller;

import com.codecool.characterhandlerservice.model.Statistics;
import com.codecool.characterhandlerservice.service.StatisticsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/")
    public ResponseEntity<String> updateStatistics(@RequestParam("characterId") Long characterId, @RequestBody Statistics statistics){
        statisticsService.updateStatisticsByCharacterId(characterId, statistics);
        return ResponseEntity.ok("Statistics updated at character with id: "+characterId);
    }
}
