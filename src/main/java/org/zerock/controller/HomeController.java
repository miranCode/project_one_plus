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
	// �̷��� �ٿ��� 
	@GetMapping(value="/") 
	// @PostMapping(value="/") 
	// value = "/"
	// value�� / ��
	// return "home"; home.jsp �� �����ض� 
	//public String home(@ModelAttribute("mode") SampleDTO mode) {
	public String home() {
		//System.out.println(mode);
		return "index";
	}	
	
	// get : ���� url �Է� or a href="" or form action="" 
	// post :  form action="" method="post" or a�±״� �ڹٽ�ũ��Ʈ�� method="post"�� �ٲ������ 
	
	//���� �ּ� ���� 
	@RequestMapping(value = "/index", method = RequestMethod.GET) 
	// method = RequestMethod.GET or POST
	public String abc() {
		// �������� �߿����� �ʾ� abc �� ���� 
		// �� �߿����� ������?
		// @RequestMapping�� ����� ��, �޼��� �̸�(���⼭�� abc())�� Ŭ���̾�Ʈ ��û�� ���������� ������ ��ġ�� �ʴ´�. 
		// ���, @RequestMapping�� value �Ӽ��� ������ URL ���(/index)��, HTTP �޼��� ���� (GET)�� �߿��ϴ�
		return "index";
	}
	
	@RequestMapping(value = "/sub", method = RequestMethod.GET)
	public void abcd() {
		// return ���� �ʾƵ� value �� ���ϰ��� ������ ���  �����
	}
	
}
