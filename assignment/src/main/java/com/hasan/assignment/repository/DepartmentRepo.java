package com.hasan.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hasan.assignment.entity.Department;
@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long>{

}
