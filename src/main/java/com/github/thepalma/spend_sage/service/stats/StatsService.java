package com.github.thepalma.spend_sage.service.stats;

import java.time.LocalDate;

import com.github.thepalma.spend_sage.dto.GraphDTO;

public interface StatsService {

    GraphDTO getGraphData(LocalDate date);

}
