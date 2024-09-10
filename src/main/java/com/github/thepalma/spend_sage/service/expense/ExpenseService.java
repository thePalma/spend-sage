package com.github.thepalma.spend_sage.service.expense;

import java.util.List;

import com.github.thepalma.spend_sage.dto.ExpenseDTO;
import com.github.thepalma.spend_sage.entity.Expense;

public interface ExpenseService {

    Expense postExpense(ExpenseDTO expanseDTO);

    List<ExpenseDTO> getAllExpenses();

    ExpenseDTO getExpenseById(Long id);

    ExpenseDTO updateExpense(Long id, ExpenseDTO expanseDTO);

    void deleteExpense(Long id);

}
