package com.example.demo._domain.blog.entity;

import com.example.demo._domain.common.errors.Exception400;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 반드시 기본 생성자가 있어야 된다.
@Entity(name = "tb_article") // ORM 기법
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {

	@Id // PK 명시 , // 연결되어 있는 PK DB로 위임
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 자동으로 1씩 올라갈 수 있도록 지정
	@Column(name = "id", updatable = false) // 추적을 못하도록 제약을 건다.
	private Long id;

	@Column(name = "title", nullable = false) // not Null --> Null 가능하다 = 아니
	private String title;

	@Column(name = "content", nullable = false) // not Null
	private String content;

	@Builder
	// 특정 생성자에만 빌더 패턴을 추가할 수 있다.
	public Article(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}
	
	// 객체의 상태 값 수정 
		public void update(String title, String content) {
			// 유효성 검사 반드시 진행 해야 함
			// 즉, 데이터가 엔티티에 저장되기 전에 반드시 검증 
			if(title == null || title.trim().isEmpty()) {
				throw new Exception400("제목은 null 이거나 빈 문자열일 수 없습니다.");
			}
			
			if(content == null || content.trim().isEmpty()) {
				throw new Exception400("내용은 null 이거나 빈 문자열일 수 없습니다.");
			}
			this.title = title;
			this.content = content;
		}

}
