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

	    // īī�� ������ ��ȿ�� ���
	    if (access_Token != null) {
	        // DTO�� ���� ����
	        mdto.setId(userInfo.get("id").toString());
	        mdto.setEmail(userInfo.get("email").toString());
	        
	        idCheck = mapper.klogin(mdto);
	        MemberDTO login = mapper.kloginGo(mdto);
	        
	        // ���̵� ����� ��� 
	        if (idCheck > 0) {
	            System.out.println("īī�� ���̵� ����");
	        } else {
	            // Mapper�� ���� DB�� ȸ�� ���
	            result = mapper.kjoin(mdto);
	            System.out.println("īī�� ȸ�����");
	        }

	        // �α��� �� ���ǿ� ����� ���� ����
	        session.setAttribute("uname", login.getUname());  // īī������ ������ nickname�� uname�� ����
	        session.setAttribute("email", login.getEmail());
	        session.setAttribute("phone_num", login.getPhone_num());

	        // ���𷺼� ��� ����
	        return "redirect:/";  // ��� ��� ��� redirect:/index ���
	    }

	    // �α��� �� ���ǿ� ����� ���� ����
	    return "redirect:/";  // ���� �ÿ��� ���𷺼�
	}
}
