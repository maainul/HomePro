package com.mainul.HomePro.service;

import com.mainul.HomePro.models.Expense;

import java.util.List;

public interface ExpenseService {
    void saveExpense(Expense expense);

    List<Expense> expenseList();

    Expense findExpenseById(Long id);

    void deleteExpenseById(Long id);


   int countExpense();



}
