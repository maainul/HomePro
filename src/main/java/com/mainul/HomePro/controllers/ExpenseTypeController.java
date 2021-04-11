package com.mainul.HomePro.controllers;

import com.mainul.HomePro.models.ExpenseType;
import com.mainul.HomePro.service.ExpenseTypeService;
import com.mainul.HomePro.springSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class ExpenseTypeController {

    @Autowired private UserService userService;
    @Autowired private ExpenseTypeService expenseTypeService;

    @GetMapping("/addExpenseType")
    public String showExpenseTypeForm(Model model) {
        ExpenseType expenseType = new ExpenseType();
        model.addAttribute("expenseType", expenseType);
        return "addExpenseType";
    }

    @PostMapping("/addExpenseType")
    public String saveExpanses(@ModelAttribute("expenseType") ExpenseType expenseType, Principal principal) {
        expenseTypeService.saveExpenseType(expenseType, userService.findByUsername(principal.getName()));
        return "redirect:/expenseTypes";
    }


    @GetMapping("/expenseTypes")
    public String expenseTypeList(Model model, Principal principal) {
        model.addAttribute("listExpense", expenseTypeService.getAllExpenseTypes(userService.findByUsername(principal.getName())));
        return "/expenseTypeList";
    }

    @GetMapping("/expenseTypeUpdateForm/{id}")
    public String expenseUpdate(@PathVariable(value = "id") Long id, Model model) {
        ExpenseType expenseType = expenseTypeService.getExpenseTypeById(id);
        model.addAttribute("expenseType", expenseType);
        return "updateExpenseType";
    }

    @GetMapping("/deleteExpenseType/{id}")
    public String expenseType(@PathVariable(value = "id") Long id, Model model){
        ExpenseType expenseType = expenseTypeService.getExpenseTypeById(id);
        expenseTypeService.removeExpenseType(id);
        return "redirect:/expenseTypes";
    }


    @GetMapping("/expenseTypeDetails/{id}")
    public String expenseTypeDetails(@PathVariable(value = "id") Long id, Model model){
        model.addAttribute("expenseType", expenseTypeService.getExpenseTypeById(id));
        return "expenseTypeDetails";
    }
}
