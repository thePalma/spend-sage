package com.github.thepalma.spend_sage.controller;

import java.time.LocalDate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.thepalma.spend_sage.dto.GraphDTO;
import com.github.thepalma.spend_sage.service.stats.StatsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/stats")
@RequiredArgsConstructor
@CrossOrigin("*")
public class StatsController {

    private final StatsService statsService;

    @RequestMapping("/graph/{date}")
    public ResponseEntity<GraphDTO> getMonthlyGraphData(@PathVariable LocalDate date) {
        return ResponseEntity.ok(statsService.getGraphData(date));
    }

}
