package com.example.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.emp.entity.Employee;
import com.example.emp.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeControlller {
	
	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/emplist")
	public String findAll(Model model) {
		List<Employee> emp = empService.findAll();
		model.addAttribute("EMPLOYEE",emp);
		return "emp.html";
	}
	
	@GetMapping("/addEmp")
	public String empForm(Model model) {
		model.addAttribute("EMPLOYEE", new Employee());
		return "form.html";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("EMPLOYEE") Employee emp) {
		empService.save(emp);
		return "redirect:/employee/emplist";
	}
	
	@GetMapping("/updateForm")
	public String updateForm(@RequestParam("empno") Integer id, Model model) {
		Employee emp = empService.findById(id);
		model.addAttribute("EMPLOYEE",emp);
		return "form.html";
	}
	
	@GetMapping("/delete")
	public String deleteById(@RequestParam("empno") Integer id) {
		empService.deleteById(id);
		
		return "redirect:/employee/emplist";
	}

}
