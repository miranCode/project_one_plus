package org.zerock.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.dto.ChargeDTO;
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
	
	// 로그인
	@GetMapping(value="login")
	public String loginGo() {
		return "member/login";
	}
	
	@PostMapping(value="login")
	public String loginPro(MemberDTO mdto, HttpSession session, Model model) {

		System.out.println(mdto);
		MemberDTO login = mapper.login(mdto);
		if(login != null) {
			System.out.println("241206 "+login);
			session.setAttribute("id", login.getId());
			session.setAttribute("uname", login.getUname());
			session.setAttribute("email", login.getEmail());
			session.setAttribute("phone_num", login.getPhone_num());
			session.setAttribute("level", login.getLevel());
			
			return "redirect:/index";
			// return "index";
		}else {
			model.addAttribute("loginError", "일치하는 정보가 없습니다."); // 로그인 실패 시 에러 메시지 추가
			return "member/login";
		}
		
	}

	
	// 회원가입 
	@GetMapping(value="join")
	public String join() {
		return "member/join";
	}
	
	@PostMapping(value="join")
	public String joinPro(MemberDTO mdto) {      
		System.out.println("회원가입 요청이 들어옴: " + mdto); 
		int result = 0;
		if(mdto != null) {
			result = mapper.join(mdto);
			return "redirect:/member/login";
		}
	    return "member/join"; // 실패 시 가입 페이지로 리다이렉트
	}
	
	
	//Id 중복 확인
	@PostMapping("/idCheck")
	@ResponseBody
	public ResponseEntity<Boolean> confirmId(String id) {
		System.out.println(id);
		boolean result = true;
		if(id.trim().isEmpty()) {
			result = false;
		} else {
			if (mapper.selectId(id)) {
				result = false;
			} else {
				result = true;
			}
		}
		System.out.println("중복" + result);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	// 비회원 인증 
	@GetMapping(value = "nonmemberlogin")
	public String nonmemberlogin() {
		return "member/nonmemberlogin";
	}
	
	@PostMapping("nonmemberlogin")
	public String nonmemberPro(HttpSession session, @RequestParam String uname, @RequestParam String phone_num, @RequestParam String email, @RequestParam String level) {
	    session.setAttribute("uname", uname);
	    session.setAttribute("email", email);
	    session.setAttribute("phone_num", phone_num);
	    session.setAttribute("level", level);
	    
	    System.out.println("uname: " + uname);
	    System.out.println("email: " + email);
	    System.out.println("phone_num: " + phone_num);
	    System.out.println("level: " + level);
	    
	    return "redirect:/index";  // 처리 후 인덱스로 리다이렉트
	}
	
	// 로그아웃, 세션 날리기 
	@GetMapping("/logout")
	public String logout(HttpSession session) {
	    session.invalidate();
	    return "redirect:/index";
	}
	
	
	// 마이페이지 
	@GetMapping("/mypage")
	public String mypage() {
		return "member/mypage";
	}
	
	// 회원정보 수정 
	
	
	// 회원 탈퇴 
	
	
	

	
}
