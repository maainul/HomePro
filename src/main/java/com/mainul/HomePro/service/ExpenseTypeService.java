package com.mainul.HomePro.service;

import com.mainul.HomePro.models.ExpenseType;

import java.util.List;

public interface ExpenseTypeService {

    void saveExpenseType(ExpenseType expenseType);

    List<ExpenseType> getAllExpenseTypes();

    ExpenseType getExpenseTypeById(Long id);

}
