package com.ms.proj.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice //handle the errors came in the controller and it will throw 
public class GlobalException {
	
	@ExceptionHandler(ResourseNotFoundException.class)
	public ResponseEntity<ErrorDetail> resourceNotFund(ResourseNotFoundException ex, WebRequest req){
		
		ErrorDetail errorDetail = new ErrorDetail(ex.getMessage(), "404", new Date());
		return new ResponseEntity<ErrorDetail>(errorDetail, HttpStatus.NOT_FOUND);
	}
}