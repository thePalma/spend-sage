package com.github.thepalma.spend_sage.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.github.thepalma.spend_sage.entity.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findByDateBetween(LocalDate startDate, LocalDate endDate);

    @Query("SELECT SUM(e.amount) FROM Expense e")
    Double sumAllAmounts();

    @Query("SELECT SUM(e.amount) FROM Expense e WHERE e.date BETWEEN :startDate AND :endDate")
    Double sumAllMonthlyAmounts(LocalDate startDate, LocalDate endDate);

    Optional<Expense> findFirstByOrderByDateDesc();

}
