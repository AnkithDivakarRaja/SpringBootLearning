package com.springboot.learning.util;

public class CustomError {

	public CustomError() {
		
	}
	
	public CustomError(String errorMessage) {
		this.errorMessage = errorMessage; 
	}
	
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
