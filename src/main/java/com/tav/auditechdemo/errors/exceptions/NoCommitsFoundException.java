package com.tav.auditechdemo.errors.exceptions;

import com.tav.auditechdemo.enums.ErrorCode;
import org.springframework.http.HttpStatus;

public class NoCommitsFoundException extends ApplicationException {

	public NoCommitsFoundException(int pullRequestNumber) {
		super(ErrorCode.NO_COMMITS_FOUND,
			  HttpStatus.NON_AUTHORITATIVE_INFORMATION,
			  "No commits were found in PR number " + pullRequestNumber
		);
	}
}
