package com.github.thepalma.spend_sage.service.income;

import java.util.List;

import com.github.thepalma.spend_sage.dto.IncomeDTO;
import com.github.thepalma.spend_sage.entity.Income;

public interface IncomeService {

    Income saveIncome(IncomeDTO incomeDTO);

    List<IncomeDTO> getAllIncomes();

    IncomeDTO getIncomeById(Long id);

    IncomeDTO updateIncome(Long id, IncomeDTO incomeDTO);

    void deleteIncome(Long id);

}
