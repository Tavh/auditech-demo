package com.tav.auditechdemo.errors.handlers;


import com.tav.auditechdemo.errors.ApiError;
import com.tav.auditechdemo.errors.exceptions.ApplicationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ApiErrorHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ApplicationException.class)
	public ResponseEntity<ApiError> handleApplicationException(ApplicationException e) {
		return new ResponseEntity<ApiError>(new ApiError(e.getId(), e.getMessage()), e.getHttpStatus());
	}
	
}
