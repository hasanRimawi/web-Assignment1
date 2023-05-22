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

import com.hasan.assignment.dto.PatientDto;
import com.hasan.assignment.service.PatientServiceImpl;

@RestController
@RequestMapping(path = "/api/pat")
public class PatientAPIs {

//	private PatientService patientService;
//	
//	public PatientAPIs(PatientService patientService) {
//		this.patientService = patientService;
//	}

	@Autowired
	private PatientServiceImpl patientService;

	@RequestMapping(path = "/**")
	public ResponseEntity<String> wrongPath() {
		return new ResponseEntity<String>("Wrong URI entered", HttpStatus.BAD_REQUEST);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<PatientDto> findPatient(@PathVariable Long id) {
		return new ResponseEntity<PatientDto>(patientService.findPatient(id), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<PatientDto>> getPatients() {
		return new ResponseEntity<List<PatientDto>>(patientService.getPatients(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<PatientDto> addPatient(@RequestBody PatientDto patient) {
		return new ResponseEntity<PatientDto>(patientService.addPatient(patient), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<PatientDto> updatePatientPhoneNumber(@RequestParam(value = "id") Long id,
			@RequestParam(value = "number") Long number) {
		return new ResponseEntity<PatientDto>(patientService.changeNumber(id, number), HttpStatus.OK);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> deleteDoc(@PathVariable Long id) {
		patientService.deletePatient(id);
		return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
	}
}
