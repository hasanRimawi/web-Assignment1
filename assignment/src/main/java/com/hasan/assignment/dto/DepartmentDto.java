package com.hasan.assignment.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class DepartmentDto {
	private Long id;
	@NotNull
	@Size(min = 3, max = 100)
	private String name;

	public DepartmentDto() {

	}

	public DepartmentDto(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
