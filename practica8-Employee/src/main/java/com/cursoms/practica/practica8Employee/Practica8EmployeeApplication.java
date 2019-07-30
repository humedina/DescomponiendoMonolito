package com.cursoms.practica.practica8Employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cursoms.practica.practica8Employee.employee.model.Employee;
import com.cursoms.practica.practica8Employee.employee.repository.EmployeeRepository;
import com.cursoms.practica.practica8Employee.utils.HRUtils;

@SpringBootApplication
public class Practica8EmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(Practica8EmployeeApplication.class, args);
	}

	private EmployeeRepository employeeRepository;

	public Practica8EmployeeApplication(EmployeeRepository employeeRepository) {

		this.employeeRepository = employeeRepository;
	}
	
	@Bean
	public CommandLineRunner startup() {

		return (args) -> {
			Employee employee = Employee.builder().firstName("Ivan").lastName("Garcia")
					.employeeNumber(HRUtils.nextEmployeeNumber()).build();

			System.out.println(employee);

			employeeRepository.save(employee);

			employee = Employee.builder().firstName("Fernanda").lastName("Morales")
					.employeeNumber(HRUtils.nextEmployeeNumber()).build();

			System.out.println(employee);

			employeeRepository.save(employee);

//			Workstation workstation = Workstation.builder().vendor("Mac").model("Mac Book Pro 15 Retina")
//					.facilitiesSerialNumber(HRUtils.nextFacilitiesSerialNumber()).build();
//
//			workstationRepository.save(workstation);
//
//			workstation = Workstation.builder().vendor("Mac").model("Mac Book Air 13")
//					.facilitiesSerialNumber(HRUtils.nextFacilitiesSerialNumber()).build();
//
//			workstationRepository.save(workstation);
//
//			workstation = Workstation.builder().vendor("Mac").model("iMac Pro 25 Retina")
//					.facilitiesSerialNumber(HRUtils.nextFacilitiesSerialNumber()).build();
//
//			workstationRepository.save(workstation);


//			Workstation ws = workstationRepository.findById(1L).get();

			Employee ivan = employeeRepository.findById(1L).get();

//			ws.setEmployee(ivan);

//			workstationRepository.save(ws);
		};
	}
}
