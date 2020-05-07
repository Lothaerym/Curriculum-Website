package com.example.demo.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AccueilController {
	
	@GetMapping("/")
	public String home(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		// test session
		Boolean isAdmin = (Boolean) session.getAttribute("isAdmin?");
		System.out.println(isAdmin);
		
		return "pages/home";
	}
}
