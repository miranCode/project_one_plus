package org.zerock.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.dto.KakaoDTO;
import org.zerock.mapper.KakaoMapper;
import org.zerock.service.KakaoService;

@Controller
public class KakaoController {
	
	@Autowired
	private KakaoMapper mapper;
	
	@Autowired
	private KakaoService service;

	@GetMapping(value="/auth/kakao/callback")
	public String kakaoLogin(KakaoDTO kdto, @RequestParam(value = "code", required = false) String code) throws Exception {
	    
	    int result = 0;
	    int idCheck = 0;
	    String access_Token = service.getAccessToken(code);
	    HashMap<String, Object> userInfo = service.getUserInfo(access_Token);
	    
	    // īī�� ������ ��ȿ�� ���
	    if (access_Token != null) {
	    	// DTO�� ���� ����
	        kdto.setId(userInfo.get("id").toString());
	        kdto.setNickname(userInfo.get("nickname").toString());
	        kdto.setEmail(userInfo.get("email").toString());
	        idCheck = mapper.klogin(kdto);
	    	// ���̵� ����� ��� 
	    	if(idCheck > 0) {
	    		System.out.println("īī�� ���̵� ����");
	    		return "/index";
	    	}else {
		        // Mapper�� ���� DB�� ȸ�� ���
		        result = mapper.kjoin(kdto);
		        System.out.println("īī�� ȸ�����");
		        return "/index";
	    	}
	    }

	    // ��� ����
	    System.out.println("###access_Token#### : " + access_Token);
	    System.out.println("###userInfo#### : " + userInfo);
	    System.out.println("###id#### : " + userInfo.get("id"));
	    System.out.println("###nickname#### : " + userInfo.get("nickname"));
	    System.out.println("###email#### : " + userInfo.get("email"));
	    
	    return "/index";
	}
}
