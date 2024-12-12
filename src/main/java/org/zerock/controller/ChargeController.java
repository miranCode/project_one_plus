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
	public String list(HttpSession session, Model model,@RequestParam(defaultValue = "1") int page) {

	    String uname = (String) session.getAttribute("uname");
	    String email = (String) session.getAttribute("email");
	    String phone_num = (String) session.getAttribute("phone_num");
	    
	    if (uname == null || email == null || phone_num == null) {
	        model.addAttribute("message", "세션이 만료되었습니다. 다시 로그인 해주세요.");
	        return "redirect:/member/login";
	    }
	    
	    int pageSize = 5;
	    int offset = (page - 1) * pageSize;
	    
	    ChargeDTO cdto = new ChargeDTO();
	    cdto.setUname((String) session.getAttribute("uname"));
	    cdto.setEmail((String) session.getAttribute("email"));
	    cdto.setPhone_num((String) session.getAttribute("phone_num"));
	    cdto.setLimit(pageSize);
	    cdto.setOffset(offset);
	    
	    System.out.println("Mapper 호출 전에 cdto: " + cdto);
	    List<ChargeDTO> chargeList = Mapper.getList(cdto);
	    
	    int totalCount = Mapper.getTotalCount(cdto);
	    int totalPages = (int) Math.ceil((double) totalCount / pageSize);
	    if (totalPages == 0) totalPages = 1;
	    
	    model.addAttribute("list", chargeList);
	    model.addAttribute("currentPage", page);
	    model.addAttribute("totalPages", totalPages);
	    model.addAttribute("totalCount", totalCount);	    
	    
	    return "charge/list";
	}

	@GetMapping(value = "charge")
	public String Detail(HttpSession session, Model model) {
		String uname = (String) session.getAttribute("uname");
	    String email = (String) session.getAttribute("email");
	    String phone_num = (String) session.getAttribute("phone_num");
	    
	    
	    if (uname == null || email == null || phone_num == null) {
	        model.addAttribute("message", "세션이 만료되었습니다. 다시 로그인 해주세요.");
	        return "redirect:/member/login";
	    }
	    
	    ChargeDTO cdto = new ChargeDTO();
	    cdto.setUname((String) session.getAttribute("uname"));
	    cdto.setEmail((String) session.getAttribute("email"));
	    cdto.setPhone_num((String) session.getAttribute("phone_num"));
	    
	    
	    List<ChargeDTO> chargeList = Mapper.getList(cdto);
	    List<ChargeDTO> pastCharges = Mapper.getPast(cdto);
	    
	    ChargeDTO TMCharge = Mapper.getThisMonthCharge(cdto);

	    System.out.println(">>>>>>>>>>>" + chargeList);
	    System.out.println(">>>>>>>>>>>" + pastCharges);
	    System.out.println(">>>>>>>>>>>" + TMCharge);
	    
	    int totalCharge = 0;
	    for (ChargeDTO charge : pastCharges) {
	        totalCharge += charge.getCharge(); // ChargeDTO의 charge 필드
	    }

	    int avgCharge = 0;
	    if (!pastCharges.isEmpty()) {
	        avgCharge = totalCharge / pastCharges.size();
	    }

	    model.addAttribute("pastCharges", pastCharges);
	    model.addAttribute("avgCharge", avgCharge);
	    model.addAttribute("list", chargeList);
	    model.addAttribute("TMCharge", TMCharge);
	    
	    return "charge/charge";
	}
}