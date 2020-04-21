package com.syneHealthInsurance.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponce {

	private String errorMessage;
	private int status;
	private long Timestamp;
	
	
}
