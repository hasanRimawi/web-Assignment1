package com.hasan.assignment.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class DoctorDto {
	private Long id;
	@NotNull
	@Size(min = 3, max = 100)
	private String name;
	@NotNull
	private String specialty;
	@NotNull
	private Long phoneNumber;

	public DoctorDto() {

	}

	public DoctorDto(String name, String specialty, Long phoneNumber) {
		this.name = name;
		this.specialty = specialty;
		this.phoneNumber = phoneNumber;
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

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
