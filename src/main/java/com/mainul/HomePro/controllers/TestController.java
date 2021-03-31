package com.mainul.HomePro.controllers;

import com.mainul.HomePro.models.Home;
import com.mainul.HomePro.service.HomeService;
import com.mainul.HomePro.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @Autowired private RoomService roomService;
    @Autowired private HomeService homeService;

    @GetMapping("/")
    public String index(Model model) {
        int count = (int) roomService.roomList().stream().count();

        model.addAttribute("count", count);

        return "index";
    }

}
