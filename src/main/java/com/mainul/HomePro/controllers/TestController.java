package com.mainul.HomePro.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/index1")
    public String index1(){
        return "index";
    }

    @GetMapping("/index2")
    public String index2(){
        return "index2";
    }


    @GetMapping("/index3")
    public String index3(){
        return "index3";
    }

    @GetMapping("/form")
    public String form(){
        return "form";
    }

}
