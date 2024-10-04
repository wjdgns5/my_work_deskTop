package com.example.demo._domain.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {
	
	// 정적 파일을 --> 어떤 폴더에 넣어야 하니? --> static 넣어야 한다.
	// http://localhost:8080/index
	@GetMapping({"/index", "/index2"})
	public String index1(Model model) {
		// 뷰 쪽으로 내려줄 데이터를 만들어 보자.
		
		String name = "길동";
		int age = 22;
		String email = "<b>a@naver.com</b>";
		String password = "asd123";
		
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		model.addAttribute("email", email);
		model.addAttribute("password", password);
		
		// viewResolver 동작 
		// src/main/resources/templates/index.mustache 를 찾을 수 있도록 파일 생성
		return "index";
	}
}
