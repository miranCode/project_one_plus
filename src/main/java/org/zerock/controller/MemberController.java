package org.zerock.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.dto.ChargeDTO;
import org.zerock.dto.MemberDTO;
import org.zerock.mapper.ChargeMapper;
import org.zerock.mapper.MemberMapper;



@Controller
@RequestMapping("/member/*") 
public class MemberController {
	
	@Autowired
	MemberMapper meper;
	
	@Autowired
	ChargeMapper cmapper;
	
	@GetMapping(value="login")
	public String loginGo() {
		return "member/login";
	}
	
	@PostMapping(value="login")
	public String loginPro(MemberDTO mdto, HttpSession session) {

		System.out.println(mdto);
		MemberDTO login = meper.login(mdto);
		if(login != null) {
			System.out.println("241206 "+login);
			session.setAttribute("id", login.getId());
			session.setAttribute("name", login.getUname());
			
			return "redirect:/index";
			// return "index";
		}
		return "member/login";
	}

	@GetMapping(value="join")
	public String join() {
		return "member/join";
	}
	
	@PostMapping("join")
	public String loginPro(MemberDTO mdto){
		return "member/login";
	}
	
	
	@GetMapping(value = "nonmemberlogin")
	public String nonmemberlogin() {
		return "member/nonmemberlogin";
	}
	
	@PostMapping("nonmemberlogin")
	public String nonmemberPro(HttpSession session, @RequestParam String name, @RequestParam String phone, @RequestParam String email) {
	    // 폼 데이터 세션에 저장
	    session.setAttribute("name", name);
	    session.setAttribute("email", email);
	    session.setAttribute("phone", phone);
	    
	    // 세션에서 값 가져오기 (디버깅용)
	    System.out.println("name: " + name);
	    System.out.println("email: " + email);
	    System.out.println("phone: " + phone);
	    
	    // 리다이렉트
	    return "redirect:/index";  // 처리 후 인덱스로 리다이렉트
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
	    session.invalidate();
	    
	    // 로그아웃 후, 메인 페이지로 리다이렉트
	    return "redirect:/index";
	}
	
	

	
}
