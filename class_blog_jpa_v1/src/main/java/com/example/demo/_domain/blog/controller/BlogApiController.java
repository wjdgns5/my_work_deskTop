package com.example.demo._domain.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo._domain.blog.dto.ArticleDTO;
import com.example.demo._domain.blog.entity.Article;
import com.example.demo._domain.blog.service.BlogService;
import com.example.demo._domain.common.ApiUtil;
import com.example.demo._domain.common.errors.Exception400;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@ResponseBody
@RequestMapping("/api")
public class BlogApiController {

	@Autowired
	private final BlogService blogService;

	// URL, 즉, 주소 설계 - http://localhost:8080/api/article
	@PostMapping("/article")
	public ResponseEntity<Article> addArticle(@RequestBody ArticleDTO dto) {
		// 1. 인증 검사
		// 2. 유효성 검사
		Article saveArticle = blogService.save(dto);
		ResponseEntity<Article> entity = ResponseEntity.status(HttpStatus.CREATED).body(saveArticle);
		return entity;
	}

	// URL, 즉, 주소 설계 - http://localhost:8080/api/article
	@GetMapping(value = "/article", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiUtil<?> getAllArticles() {

		List<Article> articles = blogService.findAll();
		if (articles.isEmpty()) {
//			return new ApiUtil<>(204, "조회된 게시글이 없습니다");
			throw new Exception400("게시글이 없습니다.");
		}
		return new ApiUtil<>(articles);
	}

	// URL , 즉, 주소 설계 - http://localhost:8080/api/articles/1
	@GetMapping(value = "/articles/{id}")
	public ApiUtil<?> findArtilcle(@PathVariable(name = "id") Long id) {
		// 1. 유효성 검사 생략
		Article article = blogService.findById(id);
		return new ApiUtil<>(article);
	}

	// URL , 즉, 주소 설계 - http://localhost:8080/api/articles/1
	@PutMapping(value = "/articles/{id}")
	public ApiUtil<?> updateArticle(@PathVariable(name = "id") Long id, @RequestBody ArticleDTO dto) {
		// 1. 인증 검사
		// 2. 유효성 검사
		Article updateArticle = blogService.update(id, dto);
		return new ApiUtil<>(updateArticle);
	}
}
