package com.tav.auditechdemo.enums;

public enum ErrorCode {
	NO_COMMITS_FOUND(1);

	
	ErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	private final int errorCode;
	
	public int getErrorCode() {
		return this.errorCode;
	}
}
