package com.sc.settlement.api.exception;

public class BadRequestException extends RuntimeException {
	
	private static final long serialVersionUID = -6953890917942584484L;

	public BadRequestException() {
		
	}
	
	public BadRequestException(String message) {
		super(message);
	}
	
	public BadRequestException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public BadRequestException(Throwable cause) {
		super(cause);
	}

}
