package org.zerock.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.dto.MemberDTO;
import org.zerock.mapper.ChargeMapper;
import org.zerock.mapper.MemberMapper;


@Controller
@RequestMapping("/member/*") 
public class MemberController {
	
	@Autowired
	MemberMapper mapper;
	
	@Autowired
	ChargeMapper cmapper;
	
	// �α���
	@GetMapping(value="login")
	public String loginGo() {
		return "member/login";
	}
	
	@PostMapping(value="login")
	public String loginPro(MemberDTO mdto, HttpSession session) {

		System.out.println(mdto);
		MemberDTO login = mapper.login(mdto);
		if(login != null) {
			System.out.println("241206 "+login);
			session.setAttribute("id", login.getId());
			session.setAttribute("name", login.getUname());
			
			return "redirect:/index";
			// return "index";
		}
		return "member/login";
	}

	
	// ȸ������ 
	@GetMapping(value="join")
	public String join() {
		return "member/join";
	}
	
	@PostMapping(value="join")
	public String joinPro(MemberDTO mdto) {      
		System.out.println("ȸ������ ��û�� ����: " + mdto); 
		int result = 0;
		if(mdto != null) {
			result = mapper.join(mdto);
			return "redirect:/member/login";
		}
	    return "member/join"; // ���� �� ���� �������� �����̷�Ʈ
	}
	

	
	// ��ȸ�� ���� 
	@GetMapping(value = "nonmemberlogin")
	public String nonmemberlogin() {
		return "member/nonmemberlogin";
	}
	
	@PostMapping("nonmemberlogin")
	public String nonmemberPro(HttpSession session, @RequestParam String name, @RequestParam String phone, @RequestParam String email) {
	    session.setAttribute("name", name);
	    session.setAttribute("email", email);
	    session.setAttribute("phone", phone);
	    
	    System.out.println("name: " + name);
	    System.out.println("email: " + email);
	    System.out.println("phone: " + phone);
	    
	    return "redirect:/index";  // ó�� �� �ε����� �����̷�Ʈ
	}
	
	// �α׾ƿ�, ���� ������ 
	@GetMapping("/logout")
	public String logout(HttpSession session) {
	    session.invalidate();
	    return "redirect:/index";
	}
	
	

	
}
