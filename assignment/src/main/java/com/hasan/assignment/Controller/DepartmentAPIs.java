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

import com.hasan.assignment.dto.DepartmentDto;
import com.hasan.assignment.service.DepartmentServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/dep")
public class DepartmentAPIs {

	@Autowired
	private DepartmentServiceImpl departmentService;

	@RequestMapping(path = "/**")
	public ResponseEntity<String> wrongPath() {
		return new ResponseEntity<String>("Wrong URI entered", HttpStatus.BAD_REQUEST);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<DepartmentDto> findDepartment(@PathVariable Long id) {
		return new ResponseEntity<DepartmentDto>(departmentService.findDepartment(id), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<DepartmentDto>> getDepartments() {
		return new ResponseEntity<List<DepartmentDto>>(departmentService.getDepartments(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<DepartmentDto> addDepartment(@Valid @RequestBody DepartmentDto department) {
		return new ResponseEntity<DepartmentDto>(departmentService.addDepartment(department), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<DepartmentDto> updateDepartmentName(@RequestParam(value = "id") Long id,
			@RequestParam(value = "name") String name) {
		return new ResponseEntity<DepartmentDto>(departmentService.changeName(id, name), HttpStatus.OK);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> deleteDep(@PathVariable Long id) {
		departmentService.deleteDepartment(id);
		return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
	}

}
