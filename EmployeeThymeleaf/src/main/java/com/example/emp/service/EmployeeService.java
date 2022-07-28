package com.example.emp.service;

import java.util.List;

import com.example.emp.entity.Employee;


public interface EmployeeService {
	public List<Employee> findAll();
	
	public void save(Employee emp);

	public void deleteById(Integer id);

	public Employee findById(Integer id);


}
