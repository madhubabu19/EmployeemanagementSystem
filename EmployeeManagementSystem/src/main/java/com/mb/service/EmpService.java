package com.mb.service;

import java.util.List;

import com.mb.entity.Employee;

public interface EmpService {
	public Employee saveEmp(Employee emp);
	public List<Employee> getAllEmp();
	public boolean deleteEmplyee(int id);
	public Employee getEmpById(int  id);
	

}
