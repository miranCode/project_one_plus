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
	        String uname = (String) session.getAttribute("name");
	        System.out.println((String) session.getAttribute("name"));
	        System.out.println(uname);
	        String email = (String) session.getAttribute("email");
	        String phone_num = (String) session.getAttribute("phone");

	        // 세션 값이 null일 경우에 대비하여 예외 처리
	        if (uname == null || email == null || phone_num == null) {
	            // 세션에 값이 없으면 로그인 페이지로 리다이렉트하거나 에러 처리
	            return "redirect:/login";  // 예시로 로그인 페이지로 리다이렉트
	        }

	        // Mapper에서 데이터 가져오기
	        List<ChargeDTO> chargeList = Mapper.getList(uname, email, phone_num);
	        
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