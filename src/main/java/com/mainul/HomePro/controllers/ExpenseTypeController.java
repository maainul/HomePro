package com.mainul.HomePro.controllers;

import com.mainul.HomePro.models.ExpenseType;
import com.mainul.HomePro.service.ExpenseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ExpenseTypeController {

    @Autowired private ExpenseTypeService expenseTypeService;

    @GetMapping("/addExpenseType")
    public String showExpenseTypeForm(Model model) {
        ExpenseType expenseType = new ExpenseType();
        model.addAttribute("expenseType", expenseType);
        return "addExpenseType";
    }

    @PostMapping("/addExpenseType")
    public String saveExpanses(@ModelAttribute("expenseType") ExpenseType expenseType) {
        expenseTypeService.saveExpenseType(expenseType);
        return "redirect:/expenseTypes";
    }


    @GetMapping("/expenseTypes")
    public String expenseTypeList(Model model) {

        model.addAttribute("listExpense", expenseTypeService.getAllExpenseTypes());
        return "/expenseTypeList";
    }

    @GetMapping("/expenseTypeUpdateForm/{id}")
    public String expenseUpdate(@PathVariable(value = "id") Long id, Model model) {
        ExpenseType expenseType = expenseTypeService.getExpenseTypeById(id);
        model.addAttribute("expenseType", expenseType);
        return "updateExpense";
    }


}
