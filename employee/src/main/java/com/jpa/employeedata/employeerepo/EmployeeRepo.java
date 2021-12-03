package com.jpa.employeedata.employeerepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.employeedata.employee.Employee;


public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
