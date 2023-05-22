package com.hasan.assignment.dto;

import java.sql.Date;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PatientDto {
	private Long id;
	@NotNull
	@Size(min = 3, max = 100)
	private String name;
	@NotNull
	private String gender;
	private Date DOB;
	@NotNull
	private Long phoneNumber;

	public PatientDto() {
	}

	public PatientDto(String name, String gender, Date DOB, Long phoneNumber) {
		this.name = name;
		this.gender = gender;
		this.DOB = DOB;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date DOB) {
		this.DOB = DOB;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
