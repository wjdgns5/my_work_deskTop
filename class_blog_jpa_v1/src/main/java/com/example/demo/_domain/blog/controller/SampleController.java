package com.example.demo._domain.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class SampleController {
	// 주소 설계 - http://localhost:8080/ (GET) 요청
	@GetMapping("/")
	public String home(HttpServletRequest request, Model model) {
		
		// 뷰 리졸브 동작
		// hello --> src/main/resources/templates/hello.mustache
		request.setAttribute("name", "반가워");
		model.addAttribute("name2", "한글 설정");
		return "hello";
	}
}
