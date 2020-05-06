package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CompetenceController {

	@GetMapping("/competence")
	public String competence() {
		return "pages/competence";
	}
}