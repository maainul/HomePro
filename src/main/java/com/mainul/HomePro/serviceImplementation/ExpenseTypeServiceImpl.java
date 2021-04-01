package com.mainul.HomePro.serviceImplementation;

import com.mainul.HomePro.models.ExpenseType;
import com.mainul.HomePro.repository.ExpenseTypeRepository;
import com.mainul.HomePro.service.ExpenseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseTypeServiceImpl implements ExpenseTypeService {
    @Autowired
    private ExpenseTypeRepository expenseRepository;


    @Override
    public void saveExpenseType(ExpenseType expenseType) {
        this.expenseRepository.save(expenseType);

    }

    @Override
    public List<ExpenseType> getAllExpenseTypes() {
        return expenseRepository.findAll();
    }

    @Override
    public ExpenseType getExpenseTypeById(Long id) {
        Optional<ExpenseType> optionalExpenseType = expenseRepository.findById(id);
        ExpenseType expenseType = null;
        if (optionalExpenseType.isPresent()){
            expenseType = optionalExpenseType.get();
        }else {
            throw new RuntimeException("Expense not found");
        }
        return expenseType;
    }
}
