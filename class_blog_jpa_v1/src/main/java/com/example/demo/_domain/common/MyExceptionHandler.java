package com.example.demo._domain.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo._domain.common.errors.Exception400;
import com.example.demo._domain.common.errors.Exception401;
import com.example.demo._domain.common.errors.Exception403;
import com.example.demo._domain.common.errors.Exception404;
import com.example.demo._domain.common.errors.Exception500;

//RuntimeException 터지면 해당 파일로 오류가 모인다.
@RestControllerAdvice // C.A --> 뷰 에러페이, R.C.A 데이터 반환 (에러)
public class MyExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);
	
	@ExceptionHandler(Exception400.class)
	public ResponseEntity<ApiUtil<Object>> ex400(Exception400 e) {
		logger.error("400 Error : {}", e.getMessage());
		ApiUtil<Object> apiUtil = new ApiUtil<>(400, e.getMessage());
		ResponseEntity<ApiUtil<Object>> entity = new ResponseEntity<>(apiUtil, HttpStatus.BAD_REQUEST);
		return entity;
	}
	
	@ExceptionHandler(Exception401.class)
	public ResponseEntity<ApiUtil<Object>> ex401(Exception401 e) {
		logger.error("401 Error : {}", e.getMessage());
		ApiUtil<Object> apiUtil = new ApiUtil<>(400, e.getMessage());
		ResponseEntity<ApiUtil<Object>> entity = new ResponseEntity<>(apiUtil, HttpStatus.UNAUTHORIZED);
		return entity;
	}
	
	@ExceptionHandler(Exception403.class)
	public ResponseEntity<ApiUtil<Object>> ex400(Exception403 e) {
		logger.error("403 Error : {}", e.getMessage());
		ApiUtil<Object> apiUtil = new ApiUtil<>(400, e.getMessage());
		ResponseEntity<ApiUtil<Object>> entity = new ResponseEntity<>(apiUtil, HttpStatus.FORBIDDEN);
		return entity;
	}
	
	@ExceptionHandler(Exception404.class)
	public ResponseEntity<ApiUtil<Object>> ex400(Exception404 e) {
		logger.error("404 Error : {}", e.getMessage());
		ApiUtil<Object> apiUtil = new ApiUtil<>(400, e.getMessage());
		ResponseEntity<ApiUtil<Object>> entity = new ResponseEntity<>(apiUtil, HttpStatus.NOT_FOUND);
		return entity;
	}
	
	@ExceptionHandler(Exception500.class)
	public ResponseEntity<ApiUtil<Object>> ex400(Exception500 e) {
		logger.error("500 Error : {}", e.getMessage());
		ApiUtil<Object> apiUtil = new ApiUtil<>(400, e.getMessage());
		ResponseEntity<ApiUtil<Object>> entity = new ResponseEntity<>(apiUtil, HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;
	}

}
