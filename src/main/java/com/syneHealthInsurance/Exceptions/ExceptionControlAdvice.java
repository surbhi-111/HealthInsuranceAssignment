package com.syneHealthInsurance.Exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionControlAdvice {

  ExceptionResponce ExcpResp = new ExceptionResponce();
  
  @ExceptionHandler()
  public ResponseEntity<ExceptionResponce> handleCompanyNotFoundException(CompanyNotFoundException exe)
  {
	  ExcpResp.setErrorMessage(exe.getMessage());
	  ExcpResp.setStatus(HttpStatus.NOT_FOUND.value());
	  ExcpResp.setTimestamp(System.currentTimeMillis());
	  
	  return new ResponseEntity<ExceptionResponce>(ExcpResp,HttpStatus.NOT_FOUND);
  }
  
	
  @ExceptionHandler
	public ResponseEntity<ExceptionResponce> handleExp(Exception exe)
	{
		
	  ExcpResp.setStatus(HttpStatus.BAD_REQUEST.value());
	  ExcpResp.setErrorMessage(exe.getMessage());
	  ExcpResp.setTimestamp(System.currentTimeMillis());
		
	  return new ResponseEntity<ExceptionResponce>(ExcpResp, HttpStatus.BAD_REQUEST);
	}
  
}
