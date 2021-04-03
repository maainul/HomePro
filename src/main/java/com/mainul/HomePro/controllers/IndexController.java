package com.mainul.HomePro.controllers;

import com.mainul.HomePro.models.Home;
import com.mainul.HomePro.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/")
    public String index(Model model) {
        int count = (int) roomService.roomList().stream().count();
        model.addAttribute("count", count);
        model.addAttribute("totalExpense", expenseService.countExpense());
        model.addAttribute("female",renterService.countFemale());
        model.addAttribute("male",renterService.countMale());
        model.addAttribute("totalRenters",renterService.totalRenter());
        model.addAttribute("electricityBill",rentService.totalElectricityBill());
        model.addAttribute("totalRent",rentService.totalRent());
        return "index";
    }

}
