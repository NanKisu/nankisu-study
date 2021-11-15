package com.study.webapp.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class NoDataException extends RuntimeException{
	public NoDataException() {
		super("NoDataException");
	}
}
