package org.example.thortfultask.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(ResponseStatusException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Mono<String> handleNotFound(final ResponseStatusException ex) {
		logger.error("Not Found Exception: ", ex);
		return Mono.just(ex.getMessage());
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Mono<String> handleException(final Exception ex) {
		logger.error("Internal Server Error: ", ex);
		return Mono.just(ex.getMessage());
	}
}