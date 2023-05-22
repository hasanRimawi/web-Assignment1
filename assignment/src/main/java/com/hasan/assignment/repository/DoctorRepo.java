package com.hasan.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hasan.assignment.entity.Doctor;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Long>{

}
