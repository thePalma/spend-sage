package com.github.thepalma.spend_sage.service.expense;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.github.thepalma.spend_sage.dto.ExpenseDTO;
import com.github.thepalma.spend_sage.entity.Expense;
import com.github.thepalma.spend_sage.repository.ExpenseRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;

    public Expense postExpense(ExpenseDTO expanseDTO) {
        Expense expanse = new Expense();
        return saveOrUpdateExpense(expanse, expanseDTO);
    }

    public List<ExpenseDTO> getAllExpenses() {
        return expenseRepository.findAll().stream()
                .sorted(Comparator.comparing(Expense::getDate).reversed())
                .map(Expense::getExpenseDTO)
                .collect(Collectors.toList());
    }

    public ExpenseDTO getExpenseById(Long id) {
        return expenseRepository.findById(id)
                .map(Expense::getExpenseDTO)
                .orElseThrow(() -> new EntityNotFoundException("Expense with id " + id + " not found"));
    }

    public ExpenseDTO updateExpense(Long id, ExpenseDTO expanseDTO) {
        return expenseRepository.findById(id)
                .map(expanse -> saveOrUpdateExpense(expanse, expanseDTO))
                .get().getExpenseDTO();
    }

    public void deleteExpense(Long id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);

        if (optionalExpense.isPresent()) {
            expenseRepository.delete(optionalExpense.get());
        } else {
            throw new EntityNotFoundException("Expense with id " + id + " not found");
        }
    }

    private Expense saveOrUpdateExpense(Expense expanse, ExpenseDTO expanseDTO) {
        expanse.setTitle(expanseDTO.getTitle());
        expanse.setDescription(expanseDTO.getDescription());
        expanse.setAmount(expanseDTO.getAmount());
        expanse.setCategory(expanseDTO.getCategory());
        expanse.setDate(expanseDTO.getDate());

        return expenseRepository.save(expanse);
    }

}
