package com.github.thepalma.spend_sage.service.stats;

import java.time.LocalDate;

import com.github.thepalma.spend_sage.dto.GraphDTO;
import com.github.thepalma.spend_sage.dto.StatsDTO;

public interface StatsService {

    GraphDTO getMonthlyGraphData(LocalDate date);

    StatsDTO getStats(LocalDate date);

}
