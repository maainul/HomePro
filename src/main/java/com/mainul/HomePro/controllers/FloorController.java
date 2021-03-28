package com.mainul.HomePro.controllers;

import com.mainul.HomePro.models.Floor;
import com.mainul.HomePro.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.Entity;

@Controller
public class FloorController {

    @Autowired
    private FloorService floorService;

    @GetMapping("/floorList")
    public String viewFloors(Model model){
       model.addAttribute("listFloors", floorService.getAllFloors());
       return "allFloorList";
    }

    @GetMapping("/addFloor")
    public String showFloorForm(Model model){
        Floor floor = new Floor();
        model.addAttribute("floor",floor);
        return "addFloorInfo";

    }

    @PostMapping("/addFloor")
    public String saveFloor(@ModelAttribute("floor") Floor floor){
        floorService.saveFloor(floor);
        return "redirect:/floorList";
    }

    @GetMapping("/floorUpdateForm/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model){
        Floor floor = floorService.getFloorById(id);
        model.addAttribute("floor", floor);
        return "updateFloor";
    }

}
