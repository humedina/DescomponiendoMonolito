package com.cursoms.practica.practica8Employee.employee.service;

import java.util.List;

import com.cursoms.practica.practica8Employee.employee.model.Employee;

public interface EmployeeService {

	List<Employee> retrieveAll();
	
	Employee retrieveById(Long id);
	
	List<Employee> retrieveByFirstName(String firstName); 

	List<Employee> retrieveByFirstNameAndLastName(String firstName, String lastName);

	Employee retrieveByEmployeeNumber(String employeeNumber);

	Employee register(Employee employee);

	Employee update(Employee employee);

	Employee delete(Employee employee);

//	Employee partialUpdate(long employeeId, Employee partialEmployee);
}
