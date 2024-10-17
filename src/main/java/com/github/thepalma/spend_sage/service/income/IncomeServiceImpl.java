package com.github.thepalma.spend_sage.service.income;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.github.thepalma.spend_sage.dto.IncomeDTO;
import com.github.thepalma.spend_sage.entity.Income;
import com.github.thepalma.spend_sage.repository.IncomeRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IncomeServiceImpl implements IncomeService {

    private final IncomeRepository incomeRepository;

    public Income saveIncome(IncomeDTO incomeDTO) {
        Income income = new Income();
        return saveOrUpdateIncome(income, incomeDTO);
    }

    public List<IncomeDTO> getAllIncomes() {
        return incomeRepository.findAll().stream()
                .sorted(Comparator.comparing(Income::getDate).reversed())
                .map(Income::getIncomeDTO)
                .collect(Collectors.toList());
    }

    public IncomeDTO getIncomeById(Long id) {
        return incomeRepository.findById(id)
                .map(Income::getIncomeDTO)
                .orElseThrow(() -> new EntityNotFoundException("Income with id " + id + " not found"));
    }

    public IncomeDTO updateIncome(Long id, IncomeDTO incomeDTO) {
        return incomeRepository.findById(id)
                .map(income -> saveOrUpdateIncome(income, incomeDTO))
                .get().getIncomeDTO();
    }

    public void deleteIncome(Long id) {
        Optional<Income> optionalIncome = incomeRepository.findById(id);

        if (optionalIncome.isPresent()) {
            incomeRepository.delete(optionalIncome.get());
        } else {
            throw new EntityNotFoundException("Income with id " + id + " not found");
        }
    }

    private Income saveOrUpdateIncome(Income income, IncomeDTO incomeDTO) {
        income.setTitle(incomeDTO.getTitle());
        income.setAmount(incomeDTO.getAmount());
        income.setDate(incomeDTO.getDate());
        income.setDescription(incomeDTO.getDescription());
        income.setCategory(incomeDTO.getCategory());
        return incomeRepository.save(income);
    }

}
