package com.example.demo._domain.blog.dto;

import com.example.demo._domain.blog.entity.Article;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDTO {
	
	private String title; // 제목
	private String content; // 내용
	
	// 여기서 ArticleDTO --> Article 데이터 타입을 변환 시키는 메서드를 만들었다.
	public Article toEntity() {
		return Article
				.builder()
				.title(this.title)
				.content(this.content)
				.build();
	}
}
