package com.jpa.employeedata.employeecontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.employeedata.employee.Employee;
import com.jpa.employeedata.employeerepo.EmployeeRepo;


@RestController
public class EmployeeController {
	@Autowired
	EmployeeRepo employeerepo;
	
	@GetMapping("/employee")
	private List<Employee> getallEmployee()
	{
		List<Employee> employee = new ArrayList<Employee>();  
		employeerepo.findAll().forEach(employee::add);  
		return employee;  
	}
	@GetMapping("/employee/{employeeid}")  
	private Employee getEmployee(@PathVariable("employeeid") int employeeid) 
	{
		return employeerepo.findById(employeeid).get();
	}
	
}
