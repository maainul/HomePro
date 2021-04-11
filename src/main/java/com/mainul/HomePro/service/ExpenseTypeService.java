package com.mainul.HomePro.service;

import com.mainul.HomePro.models.ExpenseType;
import com.mainul.HomePro.springSecurity.entity.UserEntity;

import java.util.List;

public interface ExpenseTypeService {

    void saveExpenseType(ExpenseType expenseType, UserEntity user);

    List<ExpenseType> getAllExpenseTypes(UserEntity user);

    ExpenseType getExpenseTypeById(Long id);

    void removeExpenseType(Long id);

}
