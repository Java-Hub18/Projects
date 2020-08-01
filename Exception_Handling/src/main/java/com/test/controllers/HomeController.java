package com.test.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/")
	public String homePage() {
		return "home";
	}
	
	@GetMapping("/hello")
    public String exception(Model map)
    {
			int i = 10/0; // It will throw exception java.lang.ArithmeticException: / by zero
			log.info("i = "+i);
			return "hello";
    }
}
