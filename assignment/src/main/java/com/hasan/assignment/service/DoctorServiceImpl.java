package com.hasan.assignment.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hasan.assignment.dto.DoctorDto;
import com.hasan.assignment.entity.Doctor;
import com.hasan.assignment.exception.NotFoundException;
import com.hasan.assignment.repository.DoctorRepo;

@Service
public class DoctorServiceImpl {
	@Autowired
	private DoctorRepo doctorRepo;

	public DoctorDto findDoctor(Long id) {
		Doctor temp = doctorRepo.findById(id).orElseThrow(() -> new NotFoundException("Doctor", id));
		return mapToDto(temp);
	}

	public List<DoctorDto> getDoctors() {
		return doctorRepo.findAll().stream().map(doc -> mapToDto(doc)).collect(Collectors.toList());
	}

	public DoctorDto addDoctor(DoctorDto doctor) {
		return mapToDto(doctorRepo.save(mapToEntity(doctor)));
	}

	public void deleteDoctor(Long id) {
		Doctor temp = doctorRepo.findById(id).orElseThrow(() -> new NotFoundException("Doctor", id));
		doctorRepo.delete(temp);
	}

	public DoctorDto changeNumber(Long id, Long phoneNumber) {
		Doctor temp = doctorRepo.findById(id).orElseThrow(() -> new NotFoundException("Doctor", id));
		temp.setPhoneNumber(phoneNumber);
		return mapToDto(doctorRepo.save(temp));
	}

	public Doctor mapToEntity(DoctorDto dto) {
		Doctor temp = new Doctor();
		temp.setName(dto.getName());
		temp.setPhoneNumber(dto.getPhoneNumber());
		temp.setSpecialty(dto.getSpecialty());
		return temp;
	}

	private DoctorDto mapToDto(Doctor temp) {
		DoctorDto dto = new DoctorDto();
		dto.setId(temp.getId());
		dto.setName(temp.getName());
		dto.setPhoneNumber(temp.getPhoneNumber());
		dto.setSpecialty(temp.getSpecialty());
		return dto;
	}
}
