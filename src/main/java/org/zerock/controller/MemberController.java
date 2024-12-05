package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.dto.MemberDTO;
import org.zerock.mapper.MemberMapper;


@Controller
@RequestMapping("/member/*") 
public class MemberController {
	
	@Autowired
	MemberMapper mm;
	
	@GetMapping(value="login")
	public String loginGo() {
		return "member/login";
	}
	@PostMapping(value="/login")
	//public String loginPro(@RequestParam String id, @RequestParam String pass) {
	public String loginPro(MemberDTO mdto) {

		System.out.println(mdto);
		MemberDTO login = mm.login(mdto);
		if(login != null) {

			return "index";
		}
		return "login";
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
