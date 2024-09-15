package com.github.thepalma.spend_sage.service.stats;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.github.thepalma.spend_sage.dto.GraphDTO;
import com.github.thepalma.spend_sage.dto.StatsDTO;
import com.github.thepalma.spend_sage.entity.Expense;
import com.github.thepalma.spend_sage.entity.Income;
import com.github.thepalma.spend_sage.repository.ExpenseRepository;
import com.github.thepalma.spend_sage.repository.IncomeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StatsServiceImpl implements StatsService {

    private final IncomeRepository incomeRepository;

    private final ExpenseRepository expenseRepository;

    public GraphDTO getMonthlyGraphData(LocalDate date) {

        YearMonth month = YearMonth.from(date);
        LocalDate startDate = month.atDay(1);
        LocalDate endDate = month.atEndOfMonth();

        GraphDTO graphDTO = new GraphDTO();
        graphDTO.setIncomes(incomeRepository.findByDateBetween(startDate, endDate));
        graphDTO.setExpenses(expenseRepository.findByDateBetween(startDate, endDate));
        return graphDTO;

    }

    public StatsDTO getStats(LocalDate date) {

        YearMonth month = YearMonth.from(date);
        LocalDate startDate = month.atDay(1);
        LocalDate endDate = month.atEndOfMonth();

        Double totalIncome = incomeRepository.sumAllAmounts();
        Double totalExpense = expenseRepository.sumAllAmounts();

        Double monthlyIncome = incomeRepository.sumAllMonthlyAmounts(startDate, endDate);
        Double monthlyExpense = expenseRepository.sumAllMonthlyAmounts(startDate, endDate);

        Optional<Income> latestIncome = incomeRepository.findFirstByOrderByDateDesc();
        Optional<Expense> latestExpense = expenseRepository.findFirstByOrderByDateDesc();

        StatsDTO statsDTO = new StatsDTO();
        statsDTO.setTotalIncome(totalIncome);
        statsDTO.setTotalExpense(totalExpense);
        statsDTO.setMonthlyIncome(monthlyIncome);
        statsDTO.setMonthlyExpense(monthlyExpense);
        latestIncome.ifPresent(statsDTO::setLatestIncome);
        latestExpense.ifPresent(statsDTO::setLatestExpense);

        return statsDTO;
    }

}
