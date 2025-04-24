package com.mb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mb.entity.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer> {

}
