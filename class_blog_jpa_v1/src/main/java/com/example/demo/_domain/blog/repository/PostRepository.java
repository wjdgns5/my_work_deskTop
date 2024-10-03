package com.example.demo._domain.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo._domain.blog.entity.Article;
// JpaRepository를 사용하는 이유 : 구현체를 런타임 시에 자동으로 생성해 준다.
public interface PostRepository extends JpaRepository<Article, Long> {
	
	// 기본적인 C R U D 기능을 제공한다.
	
	// 필요하다면 우리가 만들어 놓은 곳에 추가적인 쿼리나 메서드 정의가 가능하다.
}
