package com.example.demo.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Disconnect {

	@GetMapping("/disconnect")
	public String disconnect(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) {
			
		session.removeAttribute("isAdmin?");
		
		return "pages/home";
	}
	
}
