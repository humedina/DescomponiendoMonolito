package com.cursoms.practica.practica8Employee.employee.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursoms.practica.practica8Employee.employee.exceptions.EmployeeNotFoundException;
import com.cursoms.practica.practica8Employee.employee.model.Employee;
import com.cursoms.practica.practica8Employee.employee.model.Workstation;
import com.cursoms.practica.practica8Employee.employee.repository.EmployeeRepository;
import com.cursoms.practica.practica8Employee.employee.service.EmployeeService;
import com.cursoms.practica.practica8Employee.employee.workstation.exceptions.WorkstationException;
import com.cursoms.practica.practica8Employee.employee.workstation.exceptions.WorkstationNotFoundException;
import com.cursoms.practica.practica8Employee.employee.workstation.restclient.WorkstationRestClient;
import com.cursoms.practica.practica8Employee.utils.HRUtils;


@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private WorkstationRestClient workstationRestClient;

	@Override
	public List<Employee> retrieveAll() {
		List<Employee> employees = employeeRepository.findAllByOrderByIdAsc();
		LOG.info("employees size: {}", employees.size());

		for (Employee employee : employees) {
			LOG.info("employee name: {}, employee Id: {}", employee.getFirstName(), employee.getId());
			Workstation workstation = workstationRestClient.findByEmployeeId(employee.getId()).orElse(null);

			if (workstation != null) {
				employee.setWorkstation(workstation);
			} else {
				LOG.info("EL empleado no tiene WorkStation asignada...");
			}
		}

		return employees;
	}

	@Override
	public Employee retrieveById(Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
		
		Workstation ws = workstationRestClient.findByEmployeeId(employee.getId()).orElse(null);

		if (ws != null) {
			employee.setWorkstation(ws);
		}
		
		return employee;
	}

	@Override
	public List<Employee> retrieveByFirstName(String firstName) {
		return employeeRepository.findByFirstNameIgnoreCase(firstName);
	}

	@Override
	public List<Employee> retrieveByFirstNameAndLastName(String firstName, String lastName) {
		return employeeRepository.findByFirstNameIgnoreCaseAndLastNameIgnoreCase(firstName, lastName);
	}

	@Override
	public Employee retrieveByEmployeeNumber(String employeeNumber) {
		return employeeRepository.findByEmployeeNumber(employeeNumber);
	}

	@Override
	public Employee delete(Employee employee) {

		Workstation ws = employee.getWorkstation();
		if (ws != null) {
			ws.setEmployeeId(null);
			workstationRestClient.save(ws);
		}

		employeeRepository.delete(employee);
		return employee;
	}

	@Override
	public Employee register(Employee employee) {
		// Valida que NO exista registrada la WS o que no este asignada
		Workstation ws = workstationRestClient.findByFacilitiesSerialNumber(employee.getWorkstation().getFacilitiesSerialNumber());
		// Si no existe se guarda la WS con el ID del empleado
		if (ws == null) {
			LOG.info("Se guardo la WS...");
			workstationRestClient.save(employee.getWorkstation());
		} else if(ws.getEmployeeId() == null){
			ws.setEmployeeId(employee.getId());
			workstationRestClient.update(ws);
		}else if(ws.getEmployeeId() != null){
			LOG.info("La WS ya se encuentra asignada...");
		}
		employeeRepository.save(employee);
		LOG.info("Se guardo el empleado");
		return null;
	}

	@Override
	public Employee update(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	@Override
//	public Employee partialUpdate(long employeeId, Employee partialEmployee) {
//		return null;
//	}

	
}
