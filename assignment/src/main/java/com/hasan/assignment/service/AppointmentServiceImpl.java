package com.hasan.assignment.service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hasan.assignment.dto.AppointmentDto;
import com.hasan.assignment.entity.Appointment;
import com.hasan.assignment.exception.NotFoundException;
import com.hasan.assignment.repository.AppointmentRepo;

@Service
public class AppointmentServiceImpl {
	@Autowired
	private AppointmentRepo appointmentRepo;

	public AppointmentDto findAppointment(Long id) {
		Appointment temp = appointmentRepo.findById(id).orElseThrow(() -> new NotFoundException("Appointment", id));
		return mapToDto(temp);
	}

	public List<AppointmentDto> getAppointments() {
		return appointmentRepo.findAll().stream().map(app -> mapToDto(app)).collect(Collectors.toList());
	}

	public AppointmentDto addAppointment(AppointmentDto appointment) {
		return mapToDto(appointmentRepo.save(mapToEntity(appointment)));
	}

	public AppointmentDto changeDate(Long id, Date date) {
		Appointment temp = appointmentRepo.findById(id).orElseThrow(() -> new NotFoundException("Appointment", id));
		temp.setDate(date);
		return mapToDto(appointmentRepo.save(temp));
	}

	public void deleteAppointment(Long id) {
		Appointment temp = appointmentRepo.findById(id).orElseThrow(() -> new NotFoundException("Appointment", id));
		appointmentRepo.delete(temp);
	}

	public Appointment mapToEntity(AppointmentDto dto) {
		Appointment temp = new Appointment();
		temp.setDate(dto.getDate());
		return temp;
	}

	private AppointmentDto mapToDto(Appointment temp) {
		AppointmentDto dto = new AppointmentDto();
		dto.setDate(temp.getDate());
		dto.setId(temp.getId());
		return dto;
	}
}
