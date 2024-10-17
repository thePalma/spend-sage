package com.github.thepalma.spend_sage.dto;

import java.util.List;

import com.github.thepalma.spend_sage.entity.Expense;
import com.github.thepalma.spend_sage.entity.Income;

import lombok.Data;

@Data
public class GraphDTO {

    private List<Expense> expenses;

    private List<Income> incomes;

}
