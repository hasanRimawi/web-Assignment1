package com.hasan.assignment.Controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hasan.assignment.dto.AppointmentDto;
import com.hasan.assignment.service.AppointmentServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/app")
public class AppointmentAPIs {
//	private AppointmentService appointmentService;

//	public AppointmentAPIs(AppointmentService appointmentService) {
	// TODO Auto-generated constructor stub
//		this.appointmentService = appointmentService;
//	}
	@Autowired
	private AppointmentServiceImpl appointmentService;

	@RequestMapping(path = "/**")
	public ResponseEntity<String> wrongPath() {
		return new ResponseEntity<String>("Wrong URI entered", HttpStatus.BAD_REQUEST);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<AppointmentDto> findAppointment(@PathVariable Long id) {
		return new ResponseEntity<AppointmentDto>(appointmentService.findAppointment(id), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<AppointmentDto>> getAppointments() {
		return new ResponseEntity<List<AppointmentDto>>(appointmentService.getAppointments(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<AppointmentDto> addAppointment(@Valid @RequestBody AppointmentDto appointment) {
		return new ResponseEntity<AppointmentDto>(appointmentService.addAppointment(appointment), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<AppointmentDto> updateAppointment(@RequestParam(value = "id") Long id,
			@RequestParam(value = "date") Date date) {
		return new ResponseEntity<AppointmentDto>(appointmentService.changeDate(id, date), HttpStatus.OK);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> deleteApp(@PathVariable Long id) {
		appointmentService.deleteAppointment(id);
		return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
	}
}
