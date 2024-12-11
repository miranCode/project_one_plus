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
        
        // 1. Access Token 媛��졇�삤湲�
        String accessToken = service.getAccessToken(code);
        System.out.println("### Access Token ####: " + accessToken);

        // 2. �궗�슜�옄 �젙蹂� 媛��졇�삤湲�
        HashMap<String, Object> userInfo = service.getUserInfo(accessToken);
        System.out.println("### User Info ####: " + userInfo);
        System.out.println("### ID ####: " + userInfo.get("id"));
        System.out.println("### Name ####: " + userInfo.get("name"));
        System.out.println("### Email ####: " + userInfo.get("email"));
        
        // 3. �궗�슜�옄 �젙蹂대�� 湲곕컲�쑝濡� 異붽� 濡쒖쭅 (�븘�슂�떆)
        // �삁: �쉶�썝媛��엯, �꽭�뀡 ���옣, 由щ떎�씠�젆�뀡 �벑
       boolean userExists =  service.saveUser(userInfo);
       
       if (userExists) {
           // �궗�슜�옄 �젙蹂닿� ���옣�릺�뿀嫄곕굹, �씠誘� 議댁옱�븯�뒗 寃쎌슦 �꽭�뀡�뿉 ���옣
           String googleId = (String) userInfo.get("id");
           MemberDTO user = service.findUserByGoogleId(googleId);

           // �꽭�뀡�뿉 �궗�슜�옄 �젙蹂� ���옣
           HttpSession session = request.getSession();
           session.setAttribute("uname", user.getUname()); // �꽭�뀡�뿉 �궗�슜�옄 �젙蹂� ���옣
           session.setAttribute("email", user.getEmail());
           session.setAttribute("phone_num", user.getPhone_num());
           session.setAttribute("level", user.getLevel());

           System.out.println("### User logged in: " + user.getUname());
       }

       //push error
       return "/index";
    }
}
