package org.zerock.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.dto.ChargeDTO;
import org.zerock.mapper.ChargeMapper;

@Controller
@RequestMapping("/charge/*")
public class ChargeController {
	
	@Autowired
	private ChargeMapper Mapper;

	@GetMapping("list")
	public String list(HttpSession session, Model model) {
	    // ���ǿ��� �� ����
	    String uname = (String) session.getAttribute("uname");
	    String email = (String) session.getAttribute("email");
	    String phone_num = (String) session.getAttribute("phone_num");
	    System.out.println(uname + email + phone_num);
	    // ���� ���� null�� ��� ���� ó��
	    if (uname == null || email == null || phone_num == null) {
	        // ������ ������ �α��� �������� �����̷�Ʈ
	        model.addAttribute("message", "������ ����Ǿ����ϴ�. �ٽ� �α��� ���ּ���.");
	        return "redirect:/member/login"; // ���÷� �α��� �������� �����̷�Ʈ
	    }

	    // ChargeDTO�� ���� �� ����
	    ChargeDTO cdto = new ChargeDTO();
	    cdto.setUname((String) session.getAttribute("uname"));
	    cdto.setEmail((String) session.getAttribute("email"));
	    cdto.setPhone_num((String) session.getAttribute("phone_num"));
	    System.out.println(cdto);
	    // Mapper���� ������ ��������
	    List<ChargeDTO> chargeList = Mapper.getList(cdto);
	    
	    // ����� �𵨿� �߰��Ͽ� JSP�� ����
	    model.addAttribute("list", chargeList);
	    
	    return "charge/list";
	}

	
//	@GetMapping("list")
//	public String list(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("phone_num") String phone_num, Model model) {
//		System.out.println("list");
//		model.addAttribute("list", Mapper.getList(name, email, phone_num));
//		return "charge/list";
//	}
//	
	@GetMapping(value = "charge")
	public String Detail(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("phone_num") String phone_num, Model model) {
		model.addAttribute("Detail", Mapper.getDetail(name, email, phone_num));

	    return "charge/charge";
	}
}