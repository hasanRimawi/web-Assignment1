package com.hasan.assignment.Controller;

import java.util.NoSuchElementException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hasan.assignment.exception.NotFoundException;

@ControllerAdvice

public class Advice {
	@ExceptionHandler({ EmptyResultDataAccessException.class, NoSuchElementException.class, NotFoundException.class })
	public ResponseEntity<String> noMatchFound() {
		return new ResponseEntity<String>("No such object with such Id is found", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<String> badRequest() {
		return new ResponseEntity<String>("Wrong request body Syntax", HttpStatus.BAD_REQUEST);
	}
}