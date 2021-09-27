package com.sc.settlement.api.exception;

public class InvalidInputException extends RuntimeException {
	
	private static final long serialVersionUID = -1922254817080866035L;

	public InvalidInputException() {

    }

    public InvalidInputException(String message) {
        super(message);
    }

    public InvalidInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidInputException(Throwable cause) {
        super(cause);
    }

}
