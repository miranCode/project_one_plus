package org.zerock.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.dto.MemberDTO;
import org.zerock.mapper.KakaoMapper;
import org.zerock.service.KakaoService;

@Controller
public class KakaoController {
	
	@Autowired
	private KakaoMapper mapper;
	
	@Autowired
	private KakaoService service;

	@GetMapping(value="/auth/kakao/callback")
	public String kakaoLogin(MemberDTO mdto, @RequestParam(value = "code", required = false) String code, HttpSession session) throws Exception {

	    int result = 0;
	    int idCheck = 0;
	    String access_Token = service.getAccessToken(code);
	    HashMap<String, Object> userInfo = service.getUserInfo(access_Token);

	    // 카카오 정보가 유효한 경우
	    if (access_Token != null) {
	        // DTO에 값을 설정
	        mdto.setId(userInfo.get("id").toString());
	        mdto.setEmail(userInfo.get("email").toString());
	        
	        idCheck = mapper.klogin(mdto);
	        MemberDTO login = mapper.kloginGo(mdto);
	        
	        // 아이디가 저장된 경우 
	        if (idCheck > 0) {
	            System.out.println("카카오 아이디 있음");
	        } else {
	            // Mapper를 통해 DB에 회원 등록
	            result = mapper.kjoin(mdto);
	            System.out.println("카카오 회원등록");
	        }

	        // 로그인 후 세션에 사용자 정보 저장
	        session.setAttribute("uname", login.getUname());  // 카카오에서 가져온 nickname을 uname에 저장
	        session.setAttribute("email", login.getEmail());
	        session.setAttribute("phone_num", login.getPhone_num());

	        // 리디렉션 경로 수정
	        return "redirect:/";  // 상대 경로 대신 redirect:/index 사용
	    }

	    // 로그인 후 세션에 사용자 정보 저장
	    return "redirect:/";  // 실패 시에도 리디렉션
	}
}
