package com.mandava.springboot.springbootrest.demo;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class PlayerExceptionalHandler {
	@ExceptionHandler
	public ResponseEntity<PlayerErrorResponse> playerNotFound(PlayerNotFoundException ex, HttpServletRequest req) {
		PlayerErrorResponse error = new PlayerErrorResponse(
				ZonedDateTime.now(), 
				HttpStatus.NOT_FOUND.value(), 
				req.getRequestURI(), 
				ex.getMessage());
		
		return new ResponseEntity<PlayerErrorResponse>(error, HttpStatus.NOT_FOUND);
		
	}

}