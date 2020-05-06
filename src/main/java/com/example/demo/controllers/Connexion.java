package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.bean.Administrator;

@Controller
public class Connexion {

    @GetMapping("/connexion")
    public String connectAdmin(Model model) {
        
        model.addAttribute("admin", new Administrator());
        return "pages/connexion";
    }
	   
    @PostMapping("/verif")
    public String checkAdmin(@ModelAttribute Administrator admin) {

        // TODO: save project in DB here

        return "pages/home";
    }
}
