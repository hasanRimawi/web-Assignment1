package com.hasan.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hasan.assignment.entity.Patient;
@Repository
public interface PatientRepo extends JpaRepository<Patient, Long>{

}
