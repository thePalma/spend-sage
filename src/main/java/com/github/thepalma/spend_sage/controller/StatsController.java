package com.github.thepalma.spend_sage.controller;

import java.time.LocalDate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.github.thepalma.spend_sage.dto.GraphDTO;
import com.github.thepalma.spend_sage.service.stats.StatsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/stats")
@RequiredArgsConstructor
@CrossOrigin("*")
public class StatsController {

    private final StatsService statsService;

    @GetMapping("/graph/{date}")
    public ResponseEntity<GraphDTO> getMonthlyGraphData(@PathVariable LocalDate date) {
        return ResponseEntity.ok(statsService.getMonthlyGraphData(date));
    }

    @GetMapping("/{date}")
    public ResponseEntity<?> getStats(@PathVariable LocalDate date) {
        return ResponseEntity.ok(statsService.getStats(date));
    }

}
