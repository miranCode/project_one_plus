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
	    // 세션에서 값 추출
	    String uname = (String) session.getAttribute("uname");
	    String email = (String) session.getAttribute("email");
	    String phone_num = (String) session.getAttribute("phone_num");
	    System.out.println(uname + email + phone_num);
	    // 세션 값이 null일 경우 예외 처리
	    if (uname == null || email == null || phone_num == null) {
	        // 세션이 없으면 로그인 페이지로 리다이렉트
	        model.addAttribute("message", "세션이 만료되었습니다. 다시 로그인 해주세요.");
	        return "redirect:/member/login"; // 예시로 로그인 페이지로 리다이렉트
	    }

	    // ChargeDTO에 세션 값 설정
	    ChargeDTO cdto = new ChargeDTO();
	    cdto.setUname((String) session.getAttribute("uname"));
	    cdto.setEmail((String) session.getAttribute("email"));
	    cdto.setPhone_num((String) session.getAttribute("phone_num"));
	    System.out.println(cdto);
	    // Mapper에서 데이터 가져오기
	    List<ChargeDTO> chargeList = Mapper.getList(cdto);
	    
	    // 결과를 모델에 추가하여 JSP로 전달
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