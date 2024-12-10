package org.zerock.controller;


import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.dto.ChargeDTO;
import org.zerock.mapper.HomeMapper;




/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private HomeMapper homeMapper;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	 
	@GetMapping(value="/") 
	public String home() {
		return "index";
	}	
	@GetMapping(value="/index") 
	public String afterLogin(HttpSession session, Model model) {
		String uname = (String) session.getAttribute("uname");
	    String email = (String) session.getAttribute("email");
	    String phone_num = (String) session.getAttribute("phone_num");
	    System.out.println(uname);
	    System.out.println(email);
	    System.out.println(phone_num);
	    if (uname == null || email == null || phone_num == null) {
	        model.addAttribute("message", "세션이 만료되었습니다. 다시 로그인 해주세요.");
	        return "redirect:/member/login";
	    }
	    if(uname != null) {
	    	ChargeDTO cdto = new ChargeDTO();
	    	cdto.setUname(uname);
	    	cdto.setEmail(email);
	    	cdto.setPhone_num(phone_num);
	    	ChargeDTO TMCharge = homeMapper.getThisMonthCharge(cdto);
	    	System.out.println(cdto);
	    	model.addAttribute("uname", uname);
	    	model.addAttribute("TMCharge", TMCharge);
	    }
		return "index";
	}	
}
