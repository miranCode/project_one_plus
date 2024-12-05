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

@Controller // �ش� ������ ��Ʈ�ѷ���� ���� �˸��� ������̼� 
@RequestMapping("/sample/*") // ������ ���丮 �ּ� ���� // /sample/* ������ ���� ��ü 
public class SampleController {
	

	// DTO�� ���� ������ ����
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		System.out.println("" + dto);
		
		return "ex01";
	}
	// �Ϲ� ������ ������ ����
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam int age) {
		System.out.println(name);
		System.out.println(age);
		return "ex02";
	}
	
	// �迭�� ���� 
	// �迭  ArrayList<String>
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
	
	// dTO�� �迭�� ����� ������ ����
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {
		System.out.println("list" +  list);
		
		return "ex02Bean";
	}
	
	// ��¥ �ν� ��� ���� 
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
		
		// return "/sample/es04"; // forward ������� ȭ�� �̵� // ��Ʈ�ѷ� > jsp �̵� // return�� �ڵ����� .jsp �� ���� 
	    return "redirect:/"; // redirect ������� ȭ�� �̵� // ��Ʈ�ѷ� > ��Ʈ�ѷ� > jsp �̵� 
	    // redirect�δ� ���� �Ѱ��ִ� ���� �Ұ���������, 
	    // �����������ӿ�ũ������ RedirectAttributes�� �����ϰ� ����� �߰��ߴ�.
	}
	
	@GetMapping("/ex04ver")
	public String ex05ver(SampleDTO dto, RedirectAttributes rttr ) {
		
		System.out.println("dto" +  dto);
		rttr.addFlashAttribute("mode", dto);
	    return "redirect:/"; // redirect ������� ȭ�� �̵� // ��Ʈ�ѷ� > ��Ʈ�ѷ� > jsp �̵� 
	    // redirect�δ� ���� �Ѱ��ִ� ���� �Ұ���������, 
	    // �����������ӿ�ũ������ RedirectAttributes�� �����ϰ� ����� �߰��ߴ�.
	}
	
	
	// controller�� ����Ÿ�� p143
	@GetMapping("/ex05")
	public void ex05() {
		// void������ redirect ��� �Ұ� 
	}
	
	//	@GetMapping("/ex06")
	//	public String ex06() {
	//		return "ex06"; // forward ������� ȭ�� �̵�
	//	}
	
	
	// class�� Ÿ������ �ִ� �� ��ü Ÿ�� 
	// VO(Value Object), DTO(Date Transfer Object)
	// JSON �����͸� ������ �뵵 
	// **JSON (JavaScript Object Notation)**�� �����͸� �����ϰ� �����ϴ� �� ���Ǵ� �淮�� ������ �����Դϴ�. 
	// JSON�� ����� �а� �� �� ������ ��谡 �м��ϰ� ������ �� �ִ� ��������, Ư�� �� ���ø����̼ǿ��� ������ Ŭ���̾�Ʈ ���� �����͸� ��ȯ�� �� �ַ� ���
	// jsp �������� ���� ���� ��۰� ���� ������ ó���� ��� 
	// ȭ�� �����ڸ�� > network > ctrl + r > ���������� ���� // �� ���� Ȯ�� ����
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("GRAY");
		
		return dto; 
	}
	// ResponseEntity Ÿ�� 
	// Spring���� HTTP ������ Ŀ���͸���¡�ϰ�,
	// ���� �ڵ�, ���, ����(body) ���� ���� ������ �� �ֵ��� ���ִ� HTTP ���� ��ü
	
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07() {
		String msg = "{\"name\":\"ȫ�浿\"}";
		HttpHeaders headers = new HttpHeaders();
		// headers.add("Content-Type", "text/plain; charset=UTF-8");
		headers.add("Content-Type", "application/json; charset=UTF-8");
		return new ResponseEntity<>(msg, headers, HttpStatus.OK);
		// HttpStatus.OK // ����� ��Ȱ�Ҷ������� // Status Code:��

	}
	
	// ���Ͼ��ε� ó�� 
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
