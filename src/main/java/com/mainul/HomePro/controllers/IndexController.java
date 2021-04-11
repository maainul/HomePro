package com.mainul.HomePro.controllers;

import com.mainul.HomePro.models.Home;
import com.mainul.HomePro.service.*;
import com.mainul.HomePro.springSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class IndexController {

    @Autowired
    private RoomService roomService;
    @Autowired
    private HomeService homeService;
    @Autowired
    private ExpenseService expenseService;

    @Autowired
    private RentService rentService;
    @Autowired
    private RenterService renterService;

@Autowired
private UserService userService;

    @GetMapping("/")
    public String index(Model model, Principal principal) {
        int count = (int) roomService.roomList(userService.findByUsername(principal.getName())).stream().count();
        model.addAttribute("count", count);
        model.addAttribute("totalExpense", expenseService.countExpense(userService.findByUsername(principal.getName())));
        model.addAttribute("female", renterService.countFemale());
        model.addAttribute("male", renterService.countMale());
        model.addAttribute("totalRenters", renterService.totalRenter());
        model.addAttribute("electricityBill", rentService.totalElectricityBill(userService.findByUsername(principal.getName())));
        model.addAttribute("totalRent", rentService.totalRent(userService.findByUsername(principal.getName())));
        model.addAttribute("thisMonthRent", rentService.countMonthWiseRentAmount(userService.findByUsername(principal.getName())));
        model.addAttribute("thisYearRent", rentService.countCurrentYearRent(userService.findByUsername(principal.getName())));
        model.addAttribute("user",userService.firstAndLastName(principal.getName()));
        return "index";

    }
}
