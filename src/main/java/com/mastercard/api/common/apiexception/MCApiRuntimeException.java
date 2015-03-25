package com.mastercard.api.common.apiexception;

public class MCApiRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String message;
	private int httpCode;

	public MCApiRuntimeException(Exception e) {
		e.printStackTrace();
		this.initCause(e);
		this.message = e.getMessage();
	}
	
	public MCApiRuntimeException(String message, int code) {
		this.message = message;
		this.httpCode = code;
	}
	public MCApiRuntimeException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	public int getHttpCode(){
		return httpCode;
	}
}
