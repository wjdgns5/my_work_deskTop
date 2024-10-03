package com.example.demo._domain.common.errors;

public class Exception500 extends RuntimeException {
	
	// msg : // 응답 메세지 저장
	public Exception500(String msg) {
		super(msg);
	}
}
