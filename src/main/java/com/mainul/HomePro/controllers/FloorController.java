package com.mainul.HomePro.controllers;

import com.mainul.HomePro.models.Floor;
import com.mainul.HomePro.service.FloorService;
import com.mainul.HomePro.springSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.Entity;
import java.security.Principal;

@Controller
public class FloorController {

    @Autowired
    private FloorService floorService;

    @Autowired private UserService userService;

    @GetMapping("/floorList")
    public String viewFloors(Model model, Principal principal){
       model.addAttribute("listFloors", floorService.getAllFloors(userService.findByUsername(principal.getName())));
       return "allFloorList";
    }

    @GetMapping("/addFloor")
    public String showFloorForm(Model model){
        Floor floor = new Floor();
        model.addAttribute("floor",floor);
        return "addFloorInfo";

    }

    @PostMapping("/addFloor")
    public String saveFloor(@ModelAttribute("floor") Floor floor, Principal principal){
        floorService.saveFloor(floor, userService.findByUsername(principal.getName()));
        return "redirect:/floorList";
    }

    @GetMapping("/floorUpdateForm/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model){
        Floor floor = floorService.getFloorById(id);
        model.addAttribute("floor", floor);
        return "updateFloor";
    }

    @GetMapping("/floor/delete/{id}")
    public String deleteFloor(@PathVariable(value = "id") Long id){
        floorService.deleteFloorById(id);
        return "redirect:/floorList";
    }

    @GetMapping("/floorDetails/{id}")
    public String showFloorDetailsById(@PathVariable(value = "id") Long id, Model model){
        model.addAttribute("floor",floorService.getFloorById(id));
        return "floorDetails";
    }



}
