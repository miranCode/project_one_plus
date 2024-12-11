package org.zerock.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.dto.GoogleOAuthDTO;
import org.zerock.dto.MemberDTO;
import org.zerock.mapper.GoogleMapper;
import org.zerock.service.GoogleService;

@Controller
public class GoogleController {
    
    @Autowired
    private GoogleService service;
    @Autowired
	private GoogleMapper mapper;
    
    private final String googleAuthUrl = "https://accounts.google.com/o/oauth2/auth";

    // Google Login Redirect
    @GetMapping("/google/login")
    public String googleLoginRedirect(HttpServletRequest request) {
    	
    	GoogleOAuthDTO credentials = mapper.getGoogleCredentials();
    	String clientId = credentials.getClientId();
    	String redirectUri = credentials.getRedirectUri();
        String loginUrl = googleAuthUrl + 
            "?client_id=" + clientId + 
            "&redirect_uri=" + redirectUri + 
            "&response_type=code" + 
            "&scope=profile email";
        System.out.println("################" + loginUrl);
        return "redirect:" + loginUrl;
    }
    
    @RequestMapping(value = "/google/userinfo", method = RequestMethod.GET)
    public String googleLogin(@RequestParam(value = "code", required = false) String code, HttpServletRequest request) throws Exception {
        System.out.println("######### Authorization Code: " + code);
        
        // 1. Access Token 가져오기
        String accessToken = service.getAccessToken(code);
        System.out.println("### Access Token ####: " + accessToken);

        // 2. 사용자 정보 가져오기
        HashMap<String, Object> userInfo = service.getUserInfo(accessToken);
        System.out.println("### User Info ####: " + userInfo);
        System.out.println("### ID ####: " + userInfo.get("id"));
        System.out.println("### Name ####: " + userInfo.get("name"));
        System.out.println("### Email ####: " + userInfo.get("email"));
        
        // 3. 사용자 정보를 기반으로 추가 로직 (필요시)
        // 예: 회원가입, 세션 저장, 리다이렉션 등
       boolean userExists =  service.saveUser(userInfo);
       
       if (userExists) {
           // 사용자 정보가 저장되었거나, 이미 존재하는 경우 세션에 저장
           String googleId = (String) userInfo.get("id");
           MemberDTO user = service.findUserByGoogleId(googleId);

           // 세션에 사용자 정보 저장
           HttpSession session = request.getSession();
           session.setAttribute("uname", user.getUname()); // 세션에 사용자 정보 저장
           session.setAttribute("email", user.getEmail());
           session.setAttribute("phone_num", user.getPhone_num());
           session.setAttribute("level", user.getLevel());

           System.out.println("### User logged in: " + user.getUname());
           System.out.println("### User level in: " + user.getLevel());
       }

       //push error
       return "redirect:/";
    }
}
