package com.mainul.HomePro.controllers;

import com.mainul.HomePro.dto.DateFilterDTO;
import com.mainul.HomePro.models.Rent;
import com.mainul.HomePro.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.List;

@Controller
public class DatePickerController {

    @Autowired private RentService rentService;

    @GetMapping("/showMonthData")
    public String showMonthForm(Model model){
        model.addAttribute("filerDTO", new DateFilterDTO(new Date()));
        return "monthForm";
    }
    @PostMapping("/showMonthData")
    public String showMonthShow(@ModelAttribute DateFilterDTO filerDTO, Model model){
        Date date = filerDTO.getTargetDate();
        List<Rent> dateFilterDTOList = rentService.getAllDataByMonth(date);
        model.addAttribute("listRents", dateFilterDTOList);
        return "monthWiseRentDetails";
    }

}
