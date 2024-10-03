package com.example.demo._domain.common.errors;

public class Exception401 extends RuntimeException {
	
	// msg : // 응답 메세지 저장
	public Exception401(String msg) {
		super(msg);
	}
}
