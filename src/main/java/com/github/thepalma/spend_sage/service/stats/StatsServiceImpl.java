package com.github.thepalma.spend_sage.service.stats;

import java.time.LocalDate;
import java.time.YearMonth;

import org.springframework.stereotype.Service;

import com.github.thepalma.spend_sage.dto.GraphDTO;
import com.github.thepalma.spend_sage.repository.ExpenseRepository;
import com.github.thepalma.spend_sage.repository.IncomeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StatsServiceImpl implements StatsService {

    private final IncomeRepository incomeRepository;

    private final ExpenseRepository expenseRepository;

    public GraphDTO getGraphData(LocalDate date) {
        YearMonth month = YearMonth.from(date);
        LocalDate startDate = month.atDay(1);
        LocalDate endDate = month.atEndOfMonth();

        GraphDTO graphDTO = new GraphDTO();
        graphDTO.setIncomes(incomeRepository.findByDateBetween(startDate, endDate));
        graphDTO.setExpenses(expenseRepository.findByDateBetween(startDate, endDate));
        return graphDTO;
    }

}
