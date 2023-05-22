package com.hasan.assignment.dto;

import java.sql.Date;

public class AppointmentDto {
	private Long id;
	private Date date;

	public AppointmentDto() {
	}

	public AppointmentDto(Date date) {
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
