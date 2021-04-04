package com.mainul.HomePro.controllers;

import com.lowagie.text.DocumentException;
import com.mainul.HomePro.models.Expense;
import com.mainul.HomePro.service.ExpenseTypeService;
import com.mainul.HomePro.service.FloorService;
import com.mainul.HomePro.service.ExpenseService;
import com.mainul.HomePro.utils.ExpensePDFExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;
    @Autowired
    private ExpenseTypeService expenseTypeService;

    @GetMapping("/addExpense")
    public String getExpenseForm(Model model) {
        model.addAttribute("expenseTypes", expenseTypeService.getAllExpenseTypes());
        model.addAttribute("expense", new Expense());
        return "addExpenseInfo";
    }

    @PostMapping("/addExpense")
    public String saveExpense(@ModelAttribute Expense expense) {
        expenseService.saveExpense(expense);
        return "redirect:/expenseList";
    }

    @GetMapping("/expenseList")
    public String expenseList(Model model) {
        model.addAttribute("expenseList", expenseService.expenseList());
        model.addAttribute("expenseTypeList", expenseTypeService.getAllExpenseTypes());
        return "expenseList";
    }

    @GetMapping("/updateExpenseInfo/{id}")
    public String updateExpenseForm(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("expenseTypeList", expenseTypeService.getAllExpenseTypes());
        model.addAttribute("expense", expenseService.findExpenseById(id));
        return "updateExpenseInfo";
    }

    @GetMapping("/expense/export/pdf")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException, ParseException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=expenses_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        List<Expense> listExpenses = expenseService.expenseList();

        ExpensePDFExporter exporter = new ExpensePDFExporter(listExpenses);
        exporter.export(response);

    }

}
