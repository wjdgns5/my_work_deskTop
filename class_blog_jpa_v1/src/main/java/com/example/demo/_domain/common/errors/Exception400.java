package com.example.demo._domain.common.errors;

public class Exception400 extends RuntimeException {
	
	// msg : // 응답 메세지 저장
	public Exception400(String msg) {
		super(msg);
	}
}
