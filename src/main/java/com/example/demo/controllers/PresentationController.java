package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.bean.Administrator;

@Controller
public class PresentationController {
	 
    @RequestMapping(value="/editPres", method = RequestMethod.GET)
    public String editPresForm(Model model) {
        model.addAttribute("admin", new Administrator());
        
    	return "pages/connexionAdmin";
    }
	
}
