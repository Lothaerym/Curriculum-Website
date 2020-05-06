package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExperienceController {

	@GetMapping("/experience")
	public String experience() {
		return "pages/experience";
	}
}