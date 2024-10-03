package com.example.demo._domain.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo._domain.blog.dto.ArticleDTO;
import com.example.demo._domain.blog.entity.Article;
import com.example.demo._domain.blog.service.BlogService;

//final 필드와 @NonNull이 붙은 필드를 매개변수로 갖는 생성자를 자동으로 생성해
@lombok.RequiredArgsConstructor

@Controller
@ResponseBody
@RequestMapping("/api") 
public class RequiredArgsConstructor {
	
	@Autowired
	private final BlogService blogService;
	
	// URL, 즉, 주소 설계 - http://localhost:8080/api/articles
	// ResponseEntity 란? --> ResponseEntity는 HttpEntity의 확장 클래스이다.
	@PostMapping("/articles")
	public ResponseEntity<Article> addArticle(@RequestBody ArticleDTO dto) {
		
		// 1. 인증 검사
		// 2. 유효성 검사
		Article saveArticle = blogService.save(dto);
		ResponseEntity<Article> entity = ResponseEntity.status(HttpStatus.CREATED).body(saveArticle);
		return entity;
	}
	
	
	
	
	
	
}
