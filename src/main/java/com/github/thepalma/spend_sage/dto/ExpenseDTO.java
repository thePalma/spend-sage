package com.github.thepalma.spend_sage.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ExpenseDTO {

    private Long id;

    private String title;

    private String description;

    private String category;

    private LocalDate date;

    private Double amount;

}
