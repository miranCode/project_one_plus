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
import org.zerock.dto.NaverLoginDTO;
import org.zerock.mapper.NaverLoginMapper;
import org.zerock.service.NaverLoginService;

@Controller
public class NaverLoginController {
	//수정
	@Autowired
    private NaverLoginService naverLoginService;

    // 네이버 로그인 요청
    @GetMapping("/naver/login")
    public String loginWithNaver() {
    	System.out.println("aaaa");
    	System.out.println(naverLoginService.getAuthorizationUrl());
    	System.out.println("bbbb");
    	
        return "redirect:" + naverLoginService.getAuthorizationUrl();
    }

    // 네이버 콜백 처리
    @GetMapping("/naver/callback")
    public String callback(@RequestParam String code, @RequestParam String state, HttpSession session) {
        String accessToken = naverLoginService.getAccessToken(code, state);
        NaverLoginDTO userInfo = naverLoginService.getUserInfo(accessToken);
        session.setAttribute("userInfo", userInfo);
        return "/index";
    }

    @PostMapping("/naver/loginfo")
    public ResponseEntity<String> handleNaverLoginInfo(@RequestBody NaverLoginDTO loginfo, HttpSession session) {
    	int result = 0; 
        try {
            System.out.println("Raw loginfo object: " + loginfo);

            // null 체크
            if (loginfo == null) {
                System.out.println("Error: loginfo is null");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("loginfo is null.");
            }
            // 아이디 존재여부 검증 
            //if() {
            	
            //}else {
            	
            //}
            // 회원가입 
            if (loginfo.getId() == null || loginfo.getEmail() == null) {
                System.out.println("Error: ID or Email is null. ID = " + loginfo.getId() + ", Email = " + loginfo.getEmail());
                session.setAttribute("id", loginfo.getId());
    			session.setAttribute("uname", loginfo.getName());
    			session.setAttribute("email", loginfo.getEmail());
    			session.setAttribute("phone_num", loginfo.getPhoneNum());
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ID or Email is null.");
            }

            // 성공적인 처리
            boolean isSuccess = naverLoginService.processNaverLogin(loginfo);
            return isSuccess
                    ? ResponseEntity.status(HttpStatus.OK).body("Login successful")
                    : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Login failed");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred: " + e.getMessage());
        }
    }



}
