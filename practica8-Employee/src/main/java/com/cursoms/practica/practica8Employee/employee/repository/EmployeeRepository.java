package com.cursoms.practica.practica8Employee.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursoms.practica.practica8Employee.employee.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Employee findByEmployeeNumber(String employeeNumber);
	
	List<Employee> findByFirstNameIgnoreCase(String firstName);
	
	List<Employee> findByFirstNameIgnoreCaseAndLastNameIgnoreCase(String firstName, String lastName);
	
	List<Employee> findAllByOrderByIdAsc();

}
