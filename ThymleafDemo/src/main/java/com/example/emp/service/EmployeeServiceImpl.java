package com.example.emp.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.emp.entity.Employee;
import com.example.emp.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;
	
	public List<Employee> findAll(){
		return repository.findAll();
	}

	@Transactional
	public void save(Employee emp) {
		repository.save(emp);
		
	}
	

	public Employee findById(Integer id) {
		
		Optional<Employee> p =  repository.findById(id) ;
		Employee emp = null;
		
		if(p.isPresent())
			emp = p.get();
		
		return emp;
	}

	public void deleteById(Integer id) {
		repository.deleteById(id);
		
	}

}
