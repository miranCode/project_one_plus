package org.zerock.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@GetMapping({"/view","/modify"})
	public void view(@RequestParam("idx") Long idx, Model model) {
		model.addAttribute("board", service.get(idx));
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		
		if(service.modify(board)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/qna/List";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("idx") Long idx, RedirectAttributes rttr) {
		
		if(service.remove(idx)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/qna/List";
	}
	
	@PostMapping("/qna/verifyPassword")
	@ResponseBody
	public Map<String, Object> verifyPassword(@RequestBody Map<String, String> payload, HttpSession session) {
	    String idx = payload.get("idx");
	    String password = payload.get("password");

	    boolean isValid = service.verifyPassword(idx, password);

	    Map<String, Object> response = new HashMap<>();
	    if (isValid) {
	        // 비밀번호를 세션에 저장
	        session.setAttribute("password", password);
	        response.put("success", true);
	        response.put("idx", idx);
	    } else {
	        response.put("success", false);
	    }

	    return response;
	}
}
