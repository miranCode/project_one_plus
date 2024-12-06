package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.service.BoardService;

@Controller
@RequestMapping("/qna/*")
public class BoardController {
	private BoardService service;
	
//	@GetMapping("List")
//	public void list(Model model) {
//		model.addAttribute("list", service.getList());
//	}
	
	@GetMapping(value="List")
	public String loginGo() {
		return "qna/List";
	}
}
