package com.dream.spring.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping(value={"","/","index","home","default"})
	public String homePage() {		
		return "index";
	}
}
