package com.mainul.HomePro.serviceImplementation;

import com.mainul.HomePro.models.Expense;
import com.mainul.HomePro.repository.ExpenseRepository;
import com.mainul.HomePro.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public void saveExpense(Expense expense) {
        expenseRepository.save(expense);
    }

    @Override
    public List<Expense> expenseList() {
        return expenseRepository.findAll();
    }

    @Override
    public Expense findExpenseById(Long id) {
        Optional<Expense> optional = expenseRepository.findById(id);
        Expense expense = null;
        if (optional.isPresent()){
            expense = optional.get();
        }else {
            throw new RuntimeException("No Expense Found for id = " + id);
        }
        return expense;
    }

    @Override
    public int countExpense() {
        List<Expense> expenseList = expenseRepository.findAll();
        int total = expenseList.stream().collect(Collectors.summingInt((Expense::getExpenseAmount)));
        return total;
    }


}
