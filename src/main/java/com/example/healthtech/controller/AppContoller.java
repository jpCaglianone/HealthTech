package com.example.healthtech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppContoller {
    @GetMapping("/")
    public String viewHomePage() {

        return "home";
    }
}
