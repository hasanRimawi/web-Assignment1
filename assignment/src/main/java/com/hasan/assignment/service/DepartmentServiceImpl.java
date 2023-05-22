package com.hasan.assignment.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hasan.assignment.dto.DepartmentDto;
import com.hasan.assignment.entity.Department;
import com.hasan.assignment.exception.NotFoundException;
import com.hasan.assignment.repository.DepartmentRepo;

@Service
public class DepartmentServiceImpl {
	@Autowired
	private DepartmentRepo departmentRepo;

	public DepartmentDto findDepartment(Long id) {
		Department temp = departmentRepo.findById(id).orElseThrow(() -> new NotFoundException("Appointment", id));
		return mapToDto(temp);
	}

	public List<DepartmentDto> getDepartments() {
		return departmentRepo.findAll().stream().map(app -> mapToDto(app)).collect(Collectors.toList());
	}

	public DepartmentDto addDepartment(DepartmentDto appointment) {
		return mapToDto(departmentRepo.save(mapToEntity(appointment)));
	}
	
	public DepartmentDto changeName(Long id, String name) {
		Department temp = departmentRepo.findById(id).orElseThrow(() -> new NotFoundException("Department", id));
		temp.setName(name);
		return mapToDto(departmentRepo.save(temp));
	}

	public void deleteDepartment(Long id) {
		Department temp = departmentRepo.findById(id).orElseThrow(() -> new NotFoundException("Department", id));
		departmentRepo.delete(temp);
	}

	public Department mapToEntity(DepartmentDto dto) {
		Department temp = new Department();
		temp.setName(dto.getName());
		return temp;
	}

	private DepartmentDto mapToDto(Department temp) {
		DepartmentDto dto = new DepartmentDto();
		dto.setName(temp.getName());
		dto.setId(temp.getId());
		return dto;
	}
}
