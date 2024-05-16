package com.example.springbootrestapi.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.handler.ResponseStatusExceptionHandler;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseStatusExceptionHandler{
	
	@ExceptionHandler(IllegalArgumentException.class)
	public final ResponseEntity<ExceptionResponse> illegalexception(Exception exception){
		ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(),"1000",exception.getMessage());
		return new ResponseEntity<ExceptionResponse>(exceptionResponse,HttpStatus.EXPECTATION_FAILED);
	}
	
	@ExceptionHandler(UserNotFound.class)
	public final ResponseEntity<ExceptionResponse> userNotFound(Exception exception){
		ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(),"2000",exception.getMessage());
		return new ResponseEntity<ExceptionResponse>(exceptionResponse,HttpStatus.EXPECTATION_FAILED);
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> exception(Exception exception){
		ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(),"5000",exception.getMessage());
		return new ResponseEntity<ExceptionResponse>(exceptionResponse,HttpStatus.EXPECTATION_FAILED);
	}
	

}
