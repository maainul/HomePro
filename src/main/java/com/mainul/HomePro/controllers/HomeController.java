package com.mainul.HomePro.controllers;

import com.mainul.HomePro.service.ExpenseService;
import lombok.Data;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.mainul.HomePro.models.Home;

import com.mainul.HomePro.service.HomeService;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Controller
public class HomeController {

/*	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// Date -- dd/MM/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}*/

    @Autowired
    private HomeService homeService;



    @GetMapping("/homes")
    public String showHomeInfo(Model model) {
        model.addAttribute("home", homeService.getAllHome());

        return "homeDetails";
    }

    @GetMapping("/addHome")
    public String showHomeAddForm(Model model) {
        Home home = new Home();
        model.addAttribute("home", home);
        return "addOrUpdateHomeInfo";
    }

    @PostMapping("/save")
    public String saveHomeDetails(@ModelAttribute Home home, Model model) {
        homeService.saveHome(home);
        return "redirect:/homes";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get employee from the service
        Home home = homeService.getHomeById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("home", home);
        return "updateHome";
    }

}
