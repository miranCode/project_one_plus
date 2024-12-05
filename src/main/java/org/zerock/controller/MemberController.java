package org.zerock.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.dto.MemberDTO;
import org.zerock.mapper.MemberMapper;

// "@" ������̼�(Annotation)�� �ַ� ���α׷��� ���� ��Ÿ�����͸� �����ϰų�, Ư�� ������ �����ϴ� �� ���Ǵ� ������ �ּ�
// �ڵ忡 ���� �߰����� ������ �����ϰų� �����Ϸ��� ��Ÿ�ӿ��� Ư�� ó���� �� �� �ְ� ������

@Controller
@RequestMapping("/member/*") 
public class MemberController {
	
	
	// MemberMapper mm = new MemberMapper() ������ �������� 
	// ���� �ڹٿ����� �������̽��� new �� �ȵȴ�. 
	// �ڹ� �������� ��߳� ������������ ���� 
	@Autowired
	MemberMapper mm;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping(value="login")
	public String loginGo() {
		return "member/login";
	}
	@PostMapping(value="/login")
	//public String loginPro(@RequestParam String id, @RequestParam String pass) {
	public String loginPro(MemberDTO mdto) {
		// ���̵�� ��й�ȣ ���� Ȯ�� 
		System.out.println(mdto);
		MemberDTO login = mm.login(mdto);
		if(login != null) {
			// �α��� ���� ���
			// session�� ���� �� 
			
			// main�̵� 
			return "index";
		}else {
			// �α��� �Ұ��� ���
			// �ٽ� �α��� �������� �̵� 
		}
		return "login";
	}
}
