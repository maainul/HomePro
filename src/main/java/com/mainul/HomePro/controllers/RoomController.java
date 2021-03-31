package com.mainul.HomePro.controllers;

import com.mainul.HomePro.models.Floor;
import com.mainul.HomePro.models.Room;
import com.mainul.HomePro.service.FloorService;
import com.mainul.HomePro.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RoomController {

    @Autowired private RoomService roomService;
    @Autowired private FloorService floorService;

    @GetMapping("/addRoom")
    public String getRoomForm(Model model){
        model.addAttribute("floorList",floorService.getAllFloors());
        model.addAttribute("room",new Room());
        return "addRoomInfo";
    }

    @PostMapping("/addRoom")
    public String saveRoom(@ModelAttribute Room room){
        roomService.saveRoom(room);
        return "redirect:/roomList";
    }

    @GetMapping("/roomList")
    public String roomListTable(Model model){
        model.addAttribute("floorList",floorService.getAllFloors());
        model.addAttribute("roomList",roomService.roomList());
        return "roomList";
    }

    @GetMapping("/updateRoomInfo/{id}")
    public String updateRoomForm(@PathVariable(value = "id") Integer id, Model model){
        model.addAttribute("floorList", floorService.getAllFloors());
        model.addAttribute("room",roomService.findRoomById(id));
        return "updateRoomInfo";
    }

}
