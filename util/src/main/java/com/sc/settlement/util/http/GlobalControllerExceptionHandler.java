package com.sc.settlement.util.http;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sc.settlement.api.exception.BadRequestException;
import com.sc.settlement.api.exception.InvalidInputException;
import com.sc.settlement.api.exception.NotFoundException;

import lombok.extern.slf4j.Slf4j;


@RestControllerAdvice
@Slf4j
public class GlobalControllerExceptionHandler {

	@ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(NotFoundException.class)
    public HttpErrorInfo handleNotFoundExceptions(HttpServletRequest request, NotFoundException ex) {
        return createHttpErrorInfo(NOT_FOUND, request, ex);
    }

	@ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(InvalidInputException.class)
    public HttpErrorInfo handleInvalidInputException(HttpServletRequest request, InvalidInputException ex) {
        return createHttpErrorInfo(UNPROCESSABLE_ENTITY, request, ex);
    }
    
    
	@ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(BadRequestException.class)
    public HttpErrorInfo handleBadRequestException(HttpServletRequest request, BadRequestException ex) {
        return createHttpErrorInfo(BAD_REQUEST, request, ex);
    }
    
	@ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(Exception.class)
    public HttpErrorInfo handleException(HttpServletRequest request, Exception ex) {
        return createHttpErrorInfo(BAD_REQUEST, request, ex);
    }
    
    
	@ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public HttpErrorInfo handleMethodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException ex) {
    	final String path = request.getRequestURI();
    	
    	// Get all validation errors
    	final String message = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.joining(", "));
        return new HttpErrorInfo(BAD_REQUEST, path, message);
    }
    
    
    private HttpErrorInfo createHttpErrorInfo(HttpStatus httpStatus, HttpServletRequest request, Exception ex) {

        final String path = request.getRequestURI();
        final String message = ex.getMessage();

        log.debug("Returning HTTP status: {} for path: {}, message: {}", httpStatus, path, message);
        return new HttpErrorInfo(httpStatus, path, message);
    }
    
}