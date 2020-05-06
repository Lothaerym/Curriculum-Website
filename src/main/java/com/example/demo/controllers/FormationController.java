package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormationController {

	@GetMapping("/formation")
	public String formation() {
		return "pages/formation";
	}
}
