package com.mainul.HomePro.controllers;

import com.mainul.HomePro.models.Renter;
import com.mainul.HomePro.repository.RenterRepository;
import com.mainul.HomePro.service.RenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class RenterController {

/*
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
*/


    @Autowired
    private RenterService renterService;

    @GetMapping("/addRenter")
    public String showAddInfoForm(Model model) {
        Renter renter = new Renter();
        model.addAttribute("renter", renter);
        return "addRenterInfo";
    }

    @PostMapping("/addRenter")
    public String addRenter(@ModelAttribute Renter renter, Model model) {
        renterService.saveRenter(renter);
        return "redirect:/addRenter";

    }

    @GetMapping("/renterList")
    public String showRenterList(Model model) {
        model.addAttribute("renterList", renterService.renterList());
        return "renterListTable";
    }

    @GetMapping("/updateRenter/{id}")
    public String updateRenterForm(@PathVariable(value = "id") long id, Model model) {
        model.addAttribute("renter", renterService.getRenterById(id));
        return "updateRenterInfo";
    }
}
