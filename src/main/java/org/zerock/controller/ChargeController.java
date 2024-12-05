package org.zerock.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/charge/*")
public class ChargeController {
	
//	@Autowired
//	private chargeService service;
//	@GetMapping("/charge")
//	public void charge(Model model) {
//		model.addAttribute("charge", service.getcharge());
//	}
	@GetMapping(value="charge")
	public String ChargeGo() {
		return "charge/charge";
	}
	@GetMapping(value="list")
	public String GoList() {
		return "charge/list";
	}
}
