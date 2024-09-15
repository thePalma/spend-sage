package com.github.thepalma.spend_sage.dto;

import com.github.thepalma.spend_sage.entity.Expense;
import com.github.thepalma.spend_sage.entity.Income;

import lombok.Data;

@Data
public class StatsDTO {

    private Double totalIncome;

    private Double totalExpense;

    private Double monthlyIncome;

    private Double monthlyExpense;

    private Income latestIncome;

    private Expense latestExpense;

    private Double balance;

    private Double minIncome;

    private Double maxIncome;

    private Double minExpense;

    private Double maxExpense;

}
