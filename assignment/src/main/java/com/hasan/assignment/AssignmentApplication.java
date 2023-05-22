package com.hasan.assignment;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hasan.assignment.dto.AppointmentDto;
import com.hasan.assignment.dto.DepartmentDto;
import com.hasan.assignment.dto.DoctorDto;
import com.hasan.assignment.dto.PatientDto;
import com.hasan.assignment.service.AppointmentServiceImpl;
import com.hasan.assignment.service.DepartmentServiceImpl;
import com.hasan.assignment.service.DoctorServiceImpl;
import com.hasan.assignment.service.PatientServiceImpl;

@SpringBootApplication
@RestController
public class AssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentApplication.class, args);
	}

	@RequestMapping(path = "/")
	public String welcome() {
		return "Welcome to our hospital's APIs, refer to APIs documentation to use them properly";
	}

	@Bean
	CommandLineRunner cLR(DoctorServiceImpl docR, PatientServiceImpl patR, DepartmentServiceImpl depR,
			AppointmentServiceImpl appR) {
		return args -> {
			Date date1 = Date.valueOf(LocalDate.of(2022, 3, 25));
			Date date2 = Date.valueOf(LocalDate.of(2021, 7, 15));
			Date date3 = Date.valueOf(LocalDate.of(2022, 7, 15));
			Date date4 = Date.valueOf(LocalDate.of(2022, 6, 23));
			docR.addDoctor(new DoctorDto("Sameer", "Cardiologist", Long.parseLong("00972595231564")));
			docR.addDoctor(new DoctorDto("Rami", "Respiratory", Long.parseLong("00972595789654")));
			patR.addPatient(new PatientDto("Hasan", "Male", date1, Long.parseLong("00972595894895")));
			patR.addPatient(new PatientDto("Dina", "Female", date2, Long.parseLong("00972591234895")));
			depR.addDepartment(new DepartmentDto("Heart"));
			depR.addDepartment(new DepartmentDto("Emergency"));
			appR.addAppointment(new AppointmentDto(date3));
			appR.addAppointment(new AppointmentDto(date4));
		};
	}
}
