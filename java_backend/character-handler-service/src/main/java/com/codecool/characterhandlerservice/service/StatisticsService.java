package com.codecool.characterhandlerservice.service;

import com.codecool.characterhandlerservice.model.Statistics;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatisticsService {

    private static final int STARTER_VALUE_OF_BASE_STATS = 10;

    public Statistics getStarterStatistics() {
        return Statistics.builder()
                .algorithm(STARTER_VALUE_OF_BASE_STATS)
                .cleanCode(STARTER_VALUE_OF_BASE_STATS)
                .design(STARTER_VALUE_OF_BASE_STATS)
                .motivation(STARTER_VALUE_OF_BASE_STATS)
                .problemSolving(STARTER_VALUE_OF_BASE_STATS)
                .testing(STARTER_VALUE_OF_BASE_STATS)
                .build();
    }
}
