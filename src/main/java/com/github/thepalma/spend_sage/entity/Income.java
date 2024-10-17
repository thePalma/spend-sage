package com.github.thepalma.spend_sage.entity;

import java.time.LocalDate;

import com.github.thepalma.spend_sage.dto.IncomeDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Double amount;

    private LocalDate date;

    private String description;

    private String category;

    public IncomeDTO getIncomeDTO() {
        IncomeDTO incomeDTO = new IncomeDTO();
        incomeDTO.setId(this.id);
        incomeDTO.setTitle(this.title);
        incomeDTO.setAmount(this.amount);
        incomeDTO.setDate(this.date);
        incomeDTO.setDescription(this.description);
        incomeDTO.setCategory(this.category);
        return incomeDTO;
    }

}
