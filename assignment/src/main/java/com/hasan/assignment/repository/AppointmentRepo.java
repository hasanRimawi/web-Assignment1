package com.hasan.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hasan.assignment.entity.Appointment;
@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long>{

}
