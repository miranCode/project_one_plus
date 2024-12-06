package org.zerock.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.mapper.ChargeMapper;

@Controller
@RequestMapping("/charge/*")
public class ChargeController {
	
	@Autowired
	private ChargeMapper Mapper;
//	@GetMapping("/charge")
//	public void charge(Model model) {
//		model.addAttribute("charge", service.getcharge());
//	}
//	@GetMapping(value="charge")
//	public String GoCharge() {
//		return "charge/charge";
//	}
//	@GetMapping(value="list")
//	public String GoList() {
//		return "charge/list";
//	}
	@GetMapping("list")
	public String list(Model model) {
		System.out.println("list");
		model.addAttribute("list", Mapper.getList());
		return "charge/list";
	}
	
	@GetMapping(value="charge")
	public String Detail(@RequestParam("code") int code, Model model) {
		model.addAttribute("Detail", Mapper.getDetail(code));
		return "charge/charge";
	}
}