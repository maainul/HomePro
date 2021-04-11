package com.mainul.HomePro.controllers;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mainul.HomePro.service.ExpenseService;
import com.mainul.HomePro.springSecurity.entity.UserEntity;
import com.mainul.HomePro.springSecurity.service.UserService;
import lombok.Data;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.mainul.HomePro.models.Home;

import com.mainul.HomePro.service.HomeService;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private HomeService homeService;

    @Autowired
    private UserService userService;


    @GetMapping("/homes")
    public String showHomeInfo(Model model, Principal principal) {
        String name = principal.getName();
        System.out.println(name);
        List<Home> list = homeService.getAllHome(userService.findByUsername(name));
        model.addAttribute("home", list);
        return "homeDetails";
    }

    @GetMapping("/addHome")
    public String showHomeAddForm(Model model) {
        Home home = new Home();
        model.addAttribute("home", home);
        return "addOrUpdateHomeInfo";
    }

    @PostMapping("/save")
    public String saveHomeDetails(@ModelAttribute Home home, Model model,Principal principal) {
        String name = principal.getName();
        homeService.saveHome(home,userService.findByUsername(name));
        return "redirect:/homes";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Home home = homeService.getHomeById(id);
        model.addAttribute("home", home);
        return "updateHome";
    }


}
