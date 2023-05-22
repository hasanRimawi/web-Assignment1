package com.hasan.assignment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="no such user")
public class NotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String entity;
	private Long id;
	public NotFoundException(String entity, Long id) {
		super(String.format("No %s entity with such id %s was found",entity, id));
		this.entity = entity;
		this.id = id;
	}

}
