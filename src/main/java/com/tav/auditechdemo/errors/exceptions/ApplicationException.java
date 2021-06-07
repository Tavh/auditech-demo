package com.tav.auditechdemo.errors.exceptions;

import com.tav.auditechdemo.enums.ErrorCode;
import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ApplicationException extends RuntimeException {
	private Integer id;
	private HttpStatus httpStatus;
	
	public ApplicationException(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	
	public ApplicationException(ErrorCode errorCode, HttpStatus httpStatus, String message) {
		super(message);
		this.id = errorCode.getErrorCode();
		this.httpStatus = httpStatus;		
	}
}
