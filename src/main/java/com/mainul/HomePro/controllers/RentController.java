package com.mainul.HomePro.controllers;

import com.mainul.HomePro.models.Rent;
import com.mainul.HomePro.models.Room;
import com.mainul.HomePro.service.FloorService;
import com.mainul.HomePro.service.RentService;
import com.mainul.HomePro.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RentController {

    @Autowired private RoomService roomService;
    @Autowired private RentService rentService;

    @GetMapping("/addRent")
    public String getRentForm(Model model){
        model.addAttribute("rooms",roomService.roomList());
        model.addAttribute("rent", new Rent());
        return "addRent";
    }

    @PostMapping("/addRent")
    public String saveRent(@ModelAttribute Rent rent){
        rentService.saveRent(rent);
        return "redirect:/rentList";
    }

    @GetMapping("/rentList")
    public String rentListTable(Model model){
        model.addAttribute("roomList",roomService.roomList());
        model.addAttribute("rentList",rentService.getAllRent());
        return "rentList";
    }


    @GetMapping("/updateRentInfo/{id}")
    public String updateRentForm(@PathVariable(value = "id") Long id, Model model){
        model.addAttribute("roomList", roomService.roomList());
        model.addAttribute("rent",rentService.getRentById(id));
        return "updateRentInfo";
    }


    @GetMapping("/thisMonthRentDetails")
    public String thisMonthRentInfo(Model model){
        model.addAttribute("thisMonthRentDetails",rentService.currentMonthRentList());
        return "thisMonthRentDetails";
    }

}
