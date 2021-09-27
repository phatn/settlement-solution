package com.sc.settlement.api.exception;

public class NotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 2633921144697928619L;

	public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }

}
