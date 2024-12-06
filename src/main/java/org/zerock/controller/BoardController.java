package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.dto.BoardVO;
import org.zerock.service.BoardService;

@Controller
@RequestMapping("/qna/*")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping("/List")
	public void list(Model model) {
		System.out.println("list");
		model.addAttribute("list", service.getList());
	}
	
	@GetMapping("/write")
	public void write() {
		
	}
	@PostMapping("/write")
	public String write(BoardVO board, RedirectAttributes rttr) {
		
		service.register(board);
		
		rttr.addFlashAttribute("result", board.getIdx());
		
		return "redirect:/qna/List";
	}
	
	@GetMapping("/view")
	public void view(@RequestParam("idx") Long idx, Model model) {
		model.addAttribute("board", service.get(idx));
	}
}
