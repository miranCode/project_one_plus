package org.zerock.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.dto.SampleDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	// @RequestMapping(value = "/", method = RequestMethod.GET) 
	// 이렇게 줄여짐 
	@GetMapping(value="/") 
	// @PostMapping(value="/") 
	// value = "/"
	// value가 / 면
	// return "home"; home.jsp 를 실행해라 
	//public String home(@ModelAttribute("mode") SampleDTO mode) {
	public String home() {
		//System.out.println(mode);
		return "index";
	}	
	
	// get : 직접 url 입력 or a href="" or form action="" 
	// post :  form action="" method="post" or a태그는 자바스크립트로 method="post"로 바꿔줘야함 
	
	//서브 주소 연결 
	@RequestMapping(value = "/index", method = RequestMethod.GET) 
	// method = RequestMethod.GET or POST
	public String abc() {
		// 변수명이 중요하지 않아 abc 로 설정 
		// 왜 중요하지 않은가?
		// @RequestMapping을 사용할 때, 메서드 이름(여기서는 abc())은 클라이언트 요청에 직접적으로 영향을 미치지 않는다. 
		// 대신, @RequestMapping의 value 속성에 지정된 URL 경로(/index)와, HTTP 메서드 유형 (GET)이 중요하다
		return "index";
	}
	
	@RequestMapping(value = "/sub", method = RequestMethod.GET)
	public void abcd() {
		// return 하지 않아도 value 과 리턴값이 동일한 경우  실행됨
	}
	
}
