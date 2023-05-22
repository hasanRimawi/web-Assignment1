package com.hasan.assignment.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hasan.assignment.dto.PatientDto;
import com.hasan.assignment.entity.Patient;
import com.hasan.assignment.exception.NotFoundException;
import com.hasan.assignment.repository.PatientRepo;

@Service
public class PatientServiceImpl {

	@Autowired
	private PatientRepo patientRepo;

	public PatientDto findPatient(Long id) {
		Patient temp = patientRepo.findById(id).orElseThrow(() -> new NotFoundException("Patient", id));
		return mapToDto(temp);
	}

	public List<PatientDto> getPatients() {
		return patientRepo.findAll().stream().map(doc -> mapToDto(doc)).collect(Collectors.toList());
	}

	public PatientDto addPatient(PatientDto patient) {
		return mapToDto(patientRepo.save(mapToEntity(patient)));
	}

	public void deletePatient(Long id) {
		Patient temp = patientRepo.findById(id).orElseThrow(() -> new NotFoundException("Patient", id));
		patientRepo.delete(temp);
	}

	public PatientDto changeNumber(Long id, Long phoneNumber) {
		Patient temp = patientRepo.findById(id).orElseThrow(() -> new NotFoundException("Patient", id));
		temp.setPhoneNumber(phoneNumber);
		return mapToDto(patientRepo.save(temp));
	}

	public Patient mapToEntity(PatientDto dto) {
		Patient temp = new Patient();
		temp.setName(dto.getName());
		temp.setPhoneNumber(dto.getPhoneNumber());
		temp.setGender(dto.getGender());
		temp.setDOB(dto.getDOB());
		return temp;
	}

	private PatientDto mapToDto(Patient temp) {
		PatientDto dto = new PatientDto();
		dto.setName(temp.getName());
		dto.setPhoneNumber(temp.getPhoneNumber());
		dto.setGender(temp.getGender());
		dto.setDOB(temp.getDOB());
		dto.setId(temp.getId());
		return dto;
	}
}
