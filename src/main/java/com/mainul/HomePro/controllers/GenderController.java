package com.mainul.HomePro.controllers;

import com.mainul.HomePro.models.Gender;
import com.mainul.HomePro.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class GenderController {

    @Autowired
    private GenderService genderService;

    @GetMapping("/addGender")
    public String showAddGenderForm(Model model) {
        Gender gender = new Gender();
        model.addAttribute("gender", gender);
        return "addGender";
    }

    @PostMapping("/addGender")
    public String saveGender(@ModelAttribute("gender") Gender gender) {
        genderService.saveGender(gender);
        return "redirect:/addGender";
    }

    @GetMapping("/genderList")
    public String genderListPage(Model model) {
        List<Gender> genderList = genderService.getAllGenders();
        model.addAttribute("genderList",genderList);
        return "genderList";
    }

    @GetMapping("/genderUpdateForm/{id}")
    public String genderUpdateForm(@PathVariable("id") long id,Model model){
        Gender gender =  genderService.getGenderById(id);
        model.addAttribute("gender",gender);
        return "updateGenderForm";
    }

}
