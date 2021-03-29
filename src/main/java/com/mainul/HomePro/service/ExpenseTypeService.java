package com.mainul.HomePro.service;

import com.mainul.HomePro.models.ExpenseType;
import com.mainul.HomePro.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface ExpenseTypeService {

    void saveExpenseType(ExpenseType expenseType);

    List<ExpenseType> getAllExpenseTypes();

    ExpenseType getExpenseTypeById(Long id);

}
