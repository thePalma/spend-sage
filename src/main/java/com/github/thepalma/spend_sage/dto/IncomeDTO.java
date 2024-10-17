package com.github.thepalma.spend_sage.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class IncomeDTO {

    private Long id;

    private String title;

    private Double amount;

    private LocalDate date;

    private String description;

    private String category;

}
