package com.sc.settlement.util.http;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

import com.sc.settlement.api.common.ResponseStatus;

import lombok.Getter;

@Getter
public class HttpErrorInfo {
	
	private final String status = ResponseStatus.ERROR.value();
	
	private final ZonedDateTime timestamp;

    private final String path;

    private final HttpStatus httpStatus;

    private final String errorMessage;

    public HttpErrorInfo(HttpStatus httpStatus, String path, String errorMessage) {
        timestamp = ZonedDateTime.now();
        this.httpStatus = httpStatus;
        this.path = path;
        this.errorMessage = errorMessage;
    }
	
}
