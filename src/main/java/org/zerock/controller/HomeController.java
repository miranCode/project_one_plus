package org.zerock.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	 
	@GetMapping(value="/") 
	public String home() {
		return "index";
	}	
	
	@GetMapping(value="/index") 
	public String homeGo() {
		return "index";
	}	
	
	
	
}
