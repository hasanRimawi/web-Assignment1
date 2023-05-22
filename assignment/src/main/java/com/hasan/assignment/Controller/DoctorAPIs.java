package com.hasan.assignment.Controller;

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

import com.hasan.assignment.dto.DoctorDto;
import com.hasan.assignment.service.DoctorServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/doc")
public class DoctorAPIs {

//	private DoctorService doctorService;

//	public DoctorAPIs(DoctorService doctorService) {
//		this.doctorService = doctorService;
//	}
	@Autowired
	private DoctorServiceImpl doctorService;

	@RequestMapping(path = "/**")
	public ResponseEntity<String> wrongPath() {
		return new ResponseEntity<String>("Wrong URI entered", HttpStatus.BAD_REQUEST);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<DoctorDto> findDoctor(@PathVariable Long id) {
		return new ResponseEntity<DoctorDto>(doctorService.findDoctor(id), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<DoctorDto>> getDoctors() {
		return new ResponseEntity<List<DoctorDto>>(doctorService.getDoctors(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<DoctorDto> addDoctor(@Valid @RequestBody DoctorDto doctor) {
		return new ResponseEntity<DoctorDto>(doctorService.addDoctor(doctor), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<DoctorDto> updateDoctorPhoneNumber(@RequestParam(value = "id") Long id,
			@RequestParam(value = "number") Long number) {
		return new ResponseEntity<DoctorDto>(doctorService.changeNumber(id, number), HttpStatus.OK);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> deleteDoc(@PathVariable Long id) {
		doctorService.deleteDoctor(id);
		return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
	}

}
