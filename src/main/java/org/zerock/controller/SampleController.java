package org.zerock.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.dto.SampleDTO;
import org.zerock.dto.SampleDTOList;
import org.zerock.dto.TodoDTO;

@Controller // 해당 파일이 컨트롤러라는 것을 알리는 어노테이션 
@RequestMapping("/sample/*") // 동일한 디렉토리 주소 설정 // /sample/* 샘플의 하위 전체 
public class SampleController {
	

	// DTO를 통해 데이터 수집
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		System.out.println("" + dto);
		
		return "ex01";
	}
	// 일반 변수로 데이터 수집
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam int age) {
		System.out.println(name);
		System.out.println(age);
		return "ex02";
	}
	
	// 배열로 수집 
	// 배열  ArrayList<String>
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
		System.out.println("ids" +  ids);
		return "ex02List";
	}
	
	@GetMapping("/ex02Array")
	public String ex02Array(@RequestParam("ids") String[] ids) {
		System.out.println("ids" +  Arrays.toString(ids));
		
		return "ex02Array";
	}
	
	// dTO에 배열을 만들어 데이터 수집
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {
		System.out.println("list" +  list);
		
		return "ex02Bean";
	}
	
	// 날짜 인식 모양 변경 
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
//	}
	
	@GetMapping("/ex03")
	public String ex03(TodoDTO tdto) {
		System.out.println("tdto" +  tdto);
		return "ex03";
	}
	
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, Model model ) {
		model.addAttribute("mode", dto);
		
		// return "/sample/es04"; // forward 방식으로 화면 이동 // 컨트롤러 > jsp 이동 // return에 자동으로 .jsp 를 붙임 
	    return "redirect:/"; // redirect 방식으로 화면 이동 // 컨트롤러 > 컨트롤러 > jsp 이동 
	    // redirect로는 값을 넘겨주는 것이 불가능하지만, 
	    // 스프링프레임워크에서는 RedirectAttributes로 가능하게 기능을 추가했다.
	}
	
	@GetMapping("/ex04ver")
	public String ex05ver(SampleDTO dto, RedirectAttributes rttr ) {
		
		System.out.println("dto" +  dto);
		rttr.addFlashAttribute("mode", dto);
	    return "redirect:/"; // redirect 방식으로 화면 이동 // 컨트롤러 > 컨트롤러 > jsp 이동 
	    // redirect로는 값을 넘겨주는 것이 불가능하지만, 
	    // 스프링프레임워크에서는 RedirectAttributes로 가능하게 기능을 추가했다.
	}
	
	
	// controller의 리턴타입 p143
	@GetMapping("/ex05")
	public void ex05() {
		// void에서는 redirect 사용 불가 
	}
	
	//	@GetMapping("/ex06")
	//	public String ex06() {
	//		return "ex06"; // forward 방식으로 화면 이동
	//	}
	
	
	// class를 타입으로 주는 것 객체 타입 
	// VO(Value Object), DTO(Date Transfer Object)
	// JSON 데이터를 만들어내는 용도 
	// **JSON (JavaScript Object Notation)**은 데이터를 저장하고 전송하는 데 사용되는 경량의 데이터 형식입니다. 
	// JSON은 사람이 읽고 쓸 수 있으며 기계가 분석하고 생성할 수 있는 형식으로, 특히 웹 애플리케이션에서 서버와 클라이언트 간에 데이터를 교환할 때 주로 사용
	// jsp 페이지가 별도 없는 댓글과 같은 데이터 처리에 사용 
	// 화면 개발자모드 > network > ctrl + r > 페이지네임 선택 // 상세 상태 확인 가능
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("GRAY");
		
		return dto; 
	}
	// ResponseEntity 타입 
	// Spring에서 HTTP 응답을 커스터마이징하고,
	// 상태 코드, 헤더, 본문(body) 등을 직접 설정할 수 있도록 해주는 HTTP 응답 객체
	
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07() {
		String msg = "{\"name\":\"홍길동\"}";
		HttpHeaders headers = new HttpHeaders();
		// headers.add("Content-Type", "text/plain; charset=UTF-8");
		headers.add("Content-Type", "application/json; charset=UTF-8");
		return new ResponseEntity<>(msg, headers, HttpStatus.OK);
		// HttpStatus.OK // 통신이 원활할때보내라 // Status Code:ㄴ

	}
	
	// 파일업로드 처리 
	@GetMapping("/exUpload")
	public void exUpload() {
		System.out.println("/exUpload............");
	}
	
	@PostMapping("exUploadPost")
	public void exUploadPost(ArrayList<MultipartFile> files) {
		for(MultipartFile file:files) {
			System.out.println("----------------------");
			System.out.println("name "+ file.getOriginalFilename());
			System.out.println("size "+ file.getSize());
		}
	}
}
