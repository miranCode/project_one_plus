package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.dto.MemberDTO;
import org.zerock.mapper.MemberMapper;



@Controller
@RequestMapping("/member/*") 
public class MemberController {
	
	@Autowired
	MemberMapper meper;
	
	@GetMapping(value="login")
	public String loginGo() {
		return "member/login";
	}
	
	@PostMapping(value="login")
	public String loginPro(MemberDTO mdto, Model model) {

		System.out.println(mdto);
		MemberDTO login = meper.login(mdto);
		if(login != null) {
			System.out.println("241206 "+login);
			model.addAttribute("id", login.getId());
			model.addAttribute("uname", login.getUname());
			
			return "redirect:/index";
			// return "index";
		}
		return "member/login";
	}

	@GetMapping(value="join")
	public String join() {
		return "member/join";
	}
	
	@GetMapping(value = "nonmemberlogin")
	public String nonmemberlogin() {
		return "member/nonmemberlogin";
	}
}
