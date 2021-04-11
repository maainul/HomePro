package com.mainul.HomePro.service;

import com.mainul.HomePro.models.Expense;
import com.mainul.HomePro.springSecurity.entity.UserEntity;

import java.util.List;

public interface ExpenseService {
    void saveExpense(Expense expense,UserEntity user);

    List<Expense> expenseList(UserEntity user);


    Expense findExpenseById(Long id);

    void deleteExpenseById(Long id);


   int countExpense();



}
