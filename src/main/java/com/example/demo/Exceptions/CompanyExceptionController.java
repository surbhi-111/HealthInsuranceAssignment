package com.example.demo.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CompanyExceptionController {

	@ExceptionHandler(value = CompanyNotFoundException.class)
	public ResponseEntity<Object> exception(CompanyNotFoundException exception) {
	      return new ResponseEntity<>("Company not Exist with this ID", HttpStatus.NOT_FOUND);
	   }
}
