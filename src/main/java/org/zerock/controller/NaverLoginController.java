package org.zerock.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.dto.MemberDTO;
import org.zerock.dto.NaverLoginDTO;
import org.zerock.mapper.NaverLoginMapper;
import org.zerock.service.NaverLoginService;

@Controller
public class NaverLoginController {

	@Autowired
    private NaverLoginService naverLoginService;
	
	@Autowired
	private NaverLoginMapper mapper;

    @GetMapping("/naver/login")
    public String loginWithNaver() {
    	System.out.println("aaaa");
    	System.out.println(naverLoginService.getAuthorizationUrl());
    	System.out.println("bbbb");
    	
        return "redirect:" + naverLoginService.getAuthorizationUrl();
    }

    @GetMapping("/naver/callback")
    public String callback(@RequestParam String code, @RequestParam String state, HttpSession session) {
        String accessToken = naverLoginService.getAccessToken(code, state);
        MemberDTO userInfo = naverLoginService.getUserInfo(accessToken);
        MemberDTO login = mapper.selectNaverMemberById(userInfo.getId());
        System.out.println(userInfo.getId());
        System.out.println(login);
        session.setAttribute("uname", login.getUname());
        session.setAttribute("email", login.getEmail());
        session.setAttribute("phone_num", login.getPhone_num());
        session.setAttribute("level", login.getLevel());
    
        return "/index";
    }

    @PostMapping("/naver/loginfo")
    public ResponseEntity<String> handleNaverLoginInfo(@RequestBody MemberDTO loginfo, HttpSession session) {
        try {
            // loginfo가 null인 경우
            if (loginfo == null) {
                System.out.println("Error: loginfo is null");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("loginfo is null.");
            }

            System.out.println("Raw loginfo object: " + loginfo);

            // 로그인 처리
            boolean isSuccess = naverLoginService.processNaverLogin(loginfo);

            // 로그인 성공 여부에 따라 세션에 정보 저장
            if (isSuccess) {
                return ResponseEntity.status(HttpStatus.OK).body("Login successful");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Login failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred: " + e.getMessage());
        }
    }



}
