package org.zerock.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.dto.MemberDTO;
import org.zerock.mapper.MemberMapper;

// "@" 어노테이션(Annotation)은 주로 프로그래밍 언어에서 메타데이터를 정의하거나, 특정 동작을 지정하는 데 사용되는 일종의 주석
// 코드에 대한 추가적인 정보를 제공하거나 컴파일러나 런타임에서 특정 처리를 할 수 있게 도와줌

@Controller
public class MemberController {
	
	
	// MemberMapper mm = new MemberMapper() 동일한 것이지만 
	// 본래 자바에서는 인터페이스는 new 가 안된다. 
	// 자바 문법과는 어긋남 스프링에서만 가능 
	@Autowired
	MemberMapper mm;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping(value="/login")
	public String loginGo() {
		return "member/login";
	}
	@PostMapping(value="/login")
	//public String loginPro(@RequestParam String id, @RequestParam String pass) {
	public String loginPro(MemberDTO mdto) {
		// 아이디와 비밀번호 적용 확인 
		System.out.println(mdto);
		MemberDTO login = mm.login(mdto);
		if(login != null) {
			// 로그인 가능 대상
			// session에 저장 후 
			
			// main이동 
			return "index";
		}else {
			// 로그인 불가능 대상
			// 다시 로그인 페이지로 이동 
		}
		return "member/login";
	}
}
