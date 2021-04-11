package com.mainul.HomePro.controllers;

import com.mainul.HomePro.models.Floor;
import com.mainul.HomePro.models.Room;
import com.mainul.HomePro.service.FloorService;
import com.mainul.HomePro.service.RoomService;
import com.mainul.HomePro.springSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class RoomController {

    @Autowired private RoomService roomService;
    @Autowired private FloorService floorService;
    @Autowired private UserService userService;

    @GetMapping("/addRoom")
    public String getRoomForm(Model model, Principal principal){
        model.addAttribute("floors",floorService.getAllFloors(userService.findByUsername(principal.getName())));
        model.addAttribute("room", new Room());
        return "addRoomInfo";
    }

    @PostMapping("/addRoom")
    public String saveRoom(@ModelAttribute Room room, Principal principal){
        roomService.saveRoom(room, userService.findByUsername(principal.getName()));
        return "redirect:/roomList";
    }

    @GetMapping("/roomList")
    public String roomListTable(Model model,Principal principal){
        model.addAttribute("floorList",floorService.getAllFloors(userService.findByUsername(principal.getName())));
        model.addAttribute("roomList",roomService.roomList(userService.findByUsername(principal.getName())));
        return "roomList";
    }

    @GetMapping("/updateRoomInfo/{id}")
    public String updateRoomForm(@PathVariable(value = "id") Long id, Model model,Principal principal){
        model.addAttribute("floorList", floorService.getAllFloors(userService.findByUsername(principal.getName())));
        model.addAttribute("room",roomService.findRoomById(id));
        return "updateRoomInfo";
    }

    @GetMapping("/room/delete/{id}")
    public String deleteRoom(@PathVariable(value = "id") Long id, Model model){
        roomService.deleteRoom(id);
        return "redirect:/roomList";
    }

    @GetMapping("/roomDetails/{id}")
    public String roomDetailsInfo(@PathVariable(value = "id") Long id, Model model){
        model.addAttribute("room",roomService.findRoomById(id));
        return "roomDetails";
    }


}
