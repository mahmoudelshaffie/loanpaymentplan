package com.lendico.plangenerator.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value=IllegalArgumentException.class)
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public @ResponseBody String handleIllegalArgumentException(IllegalArgumentException ex) {
		return ex.getMessage();
	}
}
