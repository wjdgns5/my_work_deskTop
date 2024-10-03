package com.example.demo._domain.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo._domain.blog.dto.ArticleDTO;
import com.example.demo._domain.blog.entity.Article;
import com.example.demo._domain.blog.repository.PostRepository;
import com.example.demo._domain.common.errors.Exception400;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service // Ioc (빈으로 등록)
public class BlogService {

	@Autowired // DI --> 개발자들이 가독성 때문에 작성을 해준다.
	private final PostRepository postRepository;

	@Transactional // 모든 작업이 성공하거나, 실패 시 전체 작업이 취소(롤백)하여 데이터 일관성
	public Article save(ArticleDTO dto) {
		// 비지니스 로직이 필요하다면 작성 ...
		Article article = postRepository.save(dto.toEntity());
		return article;
	}

	// 전체 게시글 조회 기능
	public List<Article> findAll() {
		List<Article> articles = postRepository.findAll();
		return articles;
	}

	// 상세 보기 게시글 조회
	public Article findById(Long id) {
		// Optional<T>는 Java 8에서 도입된 클래스이며,
		// 값이 존재할 수도 있고 없을 수도 있는 상황을 명확하게 처리하기 위해 사용됩니다.
		// Optional 타입에 대해서 직접 조사하고 숙지 하세요(테스트 코드 작성)
		return postRepository.findById(id).orElseThrow(() -> new Exception400("해당 게시글이 없습니다."));
	}

	// 수정 비즈니스 로직에 대한 생각!
	// 영속성 컨텍스트에서 또는 DB 존재하는 Article 엔티티(row)를 가지고 와서
	// 상태 값을 수정하고 그 결과를 호출한 곳으로 반환 한다.
	@Transactional
	public Article update(Long id, ArticleDTO dto) {

		// 수정 로직
		Article articleEntity = postRepository.findById(id).orElseThrow(() -> new Exception400("not found : " + id));
		// 객체 상태 값 변경
		articleEntity.update(dto.getTitle(), dto.getContent());

		// 영속성 컨텍스트 - 더티 체킹을 알아보자.
		// 리포지토리의 save() 메서드는 수정할 때도 사용 가능 하다.
		// 단, 호출하지 않는 이유는 더티 체킹(Dirty Checking) 동작 때문이다.
		// 즉, 트랜잭션 커밋 시 자동으로 영속성 컨텍스트와 데이터베이스(DB)에 변경 사항이 반영된다
		// blogRepository.save(articleEntity);

		return articleEntity;
	}

}
