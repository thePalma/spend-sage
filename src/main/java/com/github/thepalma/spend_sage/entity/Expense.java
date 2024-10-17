package com.github.thepalma.spend_sage.entity;

import java.time.LocalDate;

import com.github.thepalma.spend_sage.dto.ExpenseDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String category;

    private LocalDate date;

    private Double amount;

    public ExpenseDTO getExpenseDTO() {
        ExpenseDTO expenseDTO = new ExpenseDTO();
        expenseDTO.setId(this.id);
        expenseDTO.setTitle(this.title);
        expenseDTO.setDescription(this.description);
        expenseDTO.setCategory(this.category);
        expenseDTO.setDate(this.date);
        expenseDTO.setAmount(this.amount);
        return expenseDTO;
    }

}
