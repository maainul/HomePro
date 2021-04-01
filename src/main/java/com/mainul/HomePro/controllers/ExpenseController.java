package com.mainul.HomePro.controllers;

import com.mainul.HomePro.models.Expense;
import com.mainul.HomePro.service.ExpenseTypeService;
import com.mainul.HomePro.service.FloorService;
import com.mainul.HomePro.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ExpenseController {
    @Autowired private ExpenseService expenseService;
    @Autowired private ExpenseTypeService expenseTypeService;

    @GetMapping("/addExpense")
    public String getExpenseForm(Model model){
        model.addAttribute("expenseTypes", expenseTypeService.getAllExpenseTypes());
       model.addAttribute("expense", new Expense());
        return "addExpenseInfo";
    }
    @PostMapping("/addExpense")
    public String saveExpense(@ModelAttribute Expense expense){
        expenseService.saveExpense(expense);
        return "redirect:/expenseList";
    }
    @GetMapping("/expenseList")
    public String expenseList(Model model){
        model.addAttribute("expenseList", expenseService.expenseList());
        model.addAttribute("expenseTypeList", expenseTypeService.getAllExpenseTypes());
        return "expenseList";
    }

    @GetMapping("/updateExpenseInfo/{id}")
    public String updateExpenseForm(@PathVariable(value = "id") Long id, Model model){
        model.addAttribute("exenseTypeList", expenseTypeService.getAllExpenseTypes());
        model.addAttribute("expense",expenseService.findExpenseById(id));
        return "updateExpenseInfo";
    }

}
