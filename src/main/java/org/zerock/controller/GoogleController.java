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
        
        // 1. Access Token 揶쏉옙占쎌죬占쎌궎疫뀐옙
        String accessToken = service.getAccessToken(code);
        System.out.println("### Access Token ####: " + accessToken);

        // 2. 占쎄텢占쎌뒠占쎌쁽 占쎌젟癰귨옙 揶쏉옙占쎌죬占쎌궎疫뀐옙
        HashMap<String, Object> userInfo = service.getUserInfo(accessToken);
        System.out.println("### User Info ####: " + userInfo);
        System.out.println("### ID ####: " + userInfo.get("id"));
        System.out.println("### Name ####: " + userInfo.get("name"));
        System.out.println("### Email ####: " + userInfo.get("email"));
        
        // 3. 占쎄텢占쎌뒠占쎌쁽 占쎌젟癰귣�占쏙옙 疫꿸퀡而뀐옙�몵嚥∽옙 �빊遺쏙옙 嚥≪뮇彛� (占쎈툡占쎌뒄占쎈뻻)
        // 占쎌굙: 占쎌돳占쎌뜚揶쏉옙占쎌뿯, 占쎄쉭占쎈�� 占쏙옙占쎌삢, �뵳�됰뼄占쎌뵠占쎌젂占쎈�� 占쎈쾻
       boolean userExists =  service.saveUser(userInfo);
       System.out.println(userExists);
       
       if (userExists) {
           // 占쎄텢占쎌뒠占쎌쁽 占쎌젟癰귣떯占� 占쏙옙占쎌삢占쎈┷占쎈�椰꾧퀡援�, 占쎌뵠沃섓옙 鈺곕똻�삺占쎈릭占쎈뮉 野껋럩�뒭 占쎄쉭占쎈�∽옙肉� 占쏙옙占쎌삢
           String googleId = (String) userInfo.get("id");
           MemberDTO user = service.findUserByGoogleId(googleId);

           // 占쎄쉭占쎈�∽옙肉� 占쎄텢占쎌뒠占쎌쁽 占쎌젟癰귨옙 占쏙옙占쎌삢
           HttpSession session = request.getSession();
           session.setAttribute("uname", user.getUname()); // 占쎄쉭占쎈�∽옙肉� 占쎄텢占쎌뒠占쎌쁽 占쎌젟癰귨옙 占쏙옙占쎌삢
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
